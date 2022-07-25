/** 剑指 Offer 24. 反转链表 https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ24 {
    public ListNode reverseList(ListNode head) {
        if(head.next==null||head==null){
            return head;
        }
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
