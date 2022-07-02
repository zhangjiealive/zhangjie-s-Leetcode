//92. 反转链表II

import java.util.ArrayList;
import java.util.LinkedList;

/** 力扣92题 https://leetcode.cn/problems/reverse-linked-list-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode92 {
    /**
     * 利用排列链表的子方法进行操作
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 对链表长度进行计数，而后全部放到一个list中（可以随机存取的结构），计算长度是为了arraylist扩大造成的开销
        ListNode tail=head;
        int count=0;
        while (tail!=null){
            count++;
            tail=tail.next;
        }
        ArrayList<ListNode> list = new ArrayList<>(count);
        tail=head;
        while (tail!=null){
            list.add(tail);
            tail=tail.next;
        }
        // 如果left==1并且right==count代表直接反转整个链表即可
        if(left==1&&right==count){
            return reverseList(head);
        }
        // 如果left==count代表不反转任何元素，直接返回头节点
        else if(left==count){
            return head;
        }
        else {
            // 从list中去取需要反转部分的左侧元素
            ListNode ldummy=list.get(left-1);
            ListNode dummy1;
            // 当left>1时，去取需要反转部分左侧元素的上一个节点
            if(left>1){
                dummy1=list.get(left-2);
            }
            // 当left==1时，虚拟一个头节点，指向头，在最后返回结果时也判定一下
            else {
                dummy1=new ListNode(-1,ldummy);
            }
            // 取需要反转部分右侧元素
            ListNode dummy2=list.get(right-1);
            // 将他的下一个节点去除
            dummy2.next=null;
            // 此时反转在反转区间的所有节点
            dummy1.next=reverseList(ldummy);
            // 此时前侧已经完全正常，但是如果right不是最后一个节点，后面就会有节点脱链
            ListNode node = ldummy;
            if(right!=count){
                // 用一个循环找到已经反转后的链表尾
                while (node.next!=null){
                    node=node.next;
                }
                // 从list去取right后面的节点，并接上
                node.next=list.get(right);
            }
            // 此时在判定 left的大小，如果大于1，返回头节点，如果小于或等于直接返回dummy1.next
            return left>1?head:dummy1.next;
        }
    }

    /**
     * 翻转链表：递归思想：以小问题的解决来完成大问题，当head为空或者head.next为空时，这是翻转链表就是他本身，
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //当head为空或者head.next为空时，这是翻转链表就是他本身，
        if(head==null||head.next==null){
            return head;
        }
        //last=翻转过来的头节点
        ListNode last = reverseList(head.next);
        // 注意head.next.next=head 例如1->2<-3<-4 此时234已经逆置，头为head，head.next.next=head,是将2的next指向1
        head.next.next=head;
        // 将1->2的链接摘除
        head.next=null;
        // 最后返回last
        return last;
    }

    ListNode successor=null;

    /**
     * 利用反转前n个节点的方法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 如果left==1的话，代表从头节点反转right个节点，直接调用reverseN方法
        if(left==1){
            return reverseN(head,right);
        }
        /* 如果left!=1时，可以想象去掉头节点，将第二个节点看作头节点进行递归，一直递归到left==1此时问题就变成了反转前N个节点
        *  注意反转的元素一直不变是right-left个，所以每次要将head.next传入参数，并且left-1（将left逐渐变为1），并且right-1，中间需要反转的元素依然不变。
         */
        head.next=reverseBetween1(head.next,left-1,right-1);
        return head;
    }

    /**
     * 从头节点，反转前right个节点
     * @param head
     * @param right
     * @return
     */
    public ListNode reverseN(ListNode head,int right) {
        if(right==1){
            successor=head.next;
            return head;
        }
        ListNode last = reverseN(head.next, right - 1);
        head.next.next=head;
        head.next=successor;
        return last;
    }


    public static void main(String[] args) {
        Leetcode92 leetcode92 = new Leetcode92();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        leetcode92.reverseBetween(l1,2,3);
    }
}
