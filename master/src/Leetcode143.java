//: Leetcode143.java

/** 力扣143题 https://leetcode.cn/problems/reorder-list/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {  //如果长度为1，递归终止，返回上个循环的尾节点，将本次唯一一个元素的下一个节点设置为null
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {  //如果长度为2，递归终止，返回上个递归的尾节点，将本次的最后一个元素的下一个节点设置为null
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //从上次递归得到本次递归需要的尾节点
        ListNode tail = reorderListHelper(head.next, len - 2);  //每次将链表的长度缩小2，无限缩小到长度为1或2触发递归终止的条件
        ListNode subHead = head.next;  //为上次递归的头节点
        head.next = tail;  //将此次递归的头节点的下个节点设置为尾节点
        ListNode outTail = tail.next;  //outTail设置为本次递归的尾节点的下一个节点，此值用来返回给上一层递归
        tail.next = subHead;  //将此次递归的尾节点的下个节点设置为上次递归的头节点
        return outTail;  //返回给上次递归，它的尾节点
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        Leetcode143 leetcode143 = new Leetcode143();
        leetcode143.reorderList(l1);
    }
}
