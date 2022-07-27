/** 142. 环形链表 II https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode142 {
    /**
     * 证明：当链表长度为a+b,a为链表到环入口距离，b为环长度
     * fast每次走两步 fast=2*low  fast=low+n*b 相遇时fast一定比low多绕了n圈
     * low每次走一步
     * 所以low走了n*b步
     * 则从head到入环口为a+n*b步，但是slow已经走了n*b,所以当head和slow同时走a步时，一定相遇，此时一定为环入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 快指针，一次走两步
        ListNode fast=head;
        // 慢指针，一次走一步
        ListNode low=head;
        // 一直往后走
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            // 直到快慢指针相遇
            if(fast==low){
                // 跳出循环
                break;
            }
        }
        // 当fast==null或fast.next==null,则代表无环
        if(fast==null||fast.next==null){
            return null;
        }
        // slow和head同时向前走，相遇时停止
        while (head!=low){
            head=head.next;
            low=low.next;
        }
        // 相遇位置就是入环口
        return low;
    }
}
