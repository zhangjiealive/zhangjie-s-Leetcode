//: Leetcode876.java

/** 力扣876. 链表的中间结点 https://leetcode.cn/problems/middle-of-the-linked-list/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;
        while (p1!=null&&p1.next!=null){
            p1=p1.next.next;
            p2=p2.next;
        }
        return p2;
    }
}
