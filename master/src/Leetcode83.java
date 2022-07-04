//83. 删除排序链表中的重复元素

/** 力扣83题 https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode83 {
    /**
     * 快慢指针 因为是有序数据，所以当快指针和慢指针指向相同的元素时，让快指针去找一个不同的元素
     * 找到以后把慢指针后面一个元素修改为快指针指向的元素，当快指针走完，慢指针以及慢指针之前的元素都是不重复的
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
            // 因为后面的链表还没有脱链，所以当fast为空时，将slow后面的所有链表脱链
            if(fast==null){
                slow.next=null;
            }
        }
        return head;
    }
}
