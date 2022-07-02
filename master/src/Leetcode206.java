//206. 反转链表

/** 力扣206题 https://leetcode.cn/problems/reverse-linked-list/
 * 递归思想，将head后面的所有节点逆置，当最后一个节点时返回节点本身，last节点接收递归逆置的结果。
 * head.next.next=head 例如1->2<-3<-4 此时234已经逆置，头为head，head.next.next=head,是将2的next指向1，head.next=null是将1指向2的指针摘除，此时成功逆置，递归结束
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
