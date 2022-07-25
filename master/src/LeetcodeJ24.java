/** 剑指 Offer 24. 反转链表 https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ24 {
    /**
     * 思路：利用递归性质
     * 此函数时逆置链表的，那么可以把问题分解为小问题
     * 先找到尾节点，假设现在只有两个节点，我们要怎么做 head——>last
     * head.next.next=head 现在变成了head<->last
     * head.next后变成了head<-last
     * 而后返回last，完成链表逆置
     * 递归：自顶向下，到最小问题时解决问题，而后层层向上递归，从而解决整个问题
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // base case 当找到尾节点，返回此节点
        if(head==null||head.next==null){
            return head;
        }
        // last为现在找到的尾节点，reverseList方法会逆置整个链表，最后返回last即可
        ListNode last=reverseList(head.next);
        // 后序遍历位置，在到达尾之后进行的操作
        // 递归层层增加逆向链，将正向链接脱链
        head.next.next=head;
        head.next=null;
        return last;
    }
}
