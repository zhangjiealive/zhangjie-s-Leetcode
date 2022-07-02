//25. K 个一组翻转链表

/** 力扣25题 https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode25 {
    /**
     * 递归实现
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果目前head为空返回空
        if(head==null){
            return null;
        }
        ListNode a,b;
        // a和b都指向头节点
        a=b=head;
        // 将b节点往后移动k个
        for (int i = 0; i < k; i++) {
            // 如果b在移动过程中为空，则不进行反转直接返回head
            if(b==null) return head;
            b=b.next;
        }
        // 调用将a,b之间反转的方法
        ListNode newNode=reverse(a,b);
        // 此时a到b已经反转，注意，a此时为ab链表的尾，b为头，接下来递归调用reverseKGroup方法，a.next==接下来递归反转的队头
        a.next=reverseKGroup(b,k);
        // 最后返回newNode，此时newNode中存储队头，也是就是第一次递归中的b
        return newNode;
    }

    /**
     * 迭代反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode pre,cur,nxt;
        pre=null;
        cur=head;
        nxt=head;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    /**
     * 迭代反转a,b之间的链表
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre,cur,nxt;
        pre=null;
        cur=a;
        nxt=a;
        while (cur!=b){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
