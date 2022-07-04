//234. K 个一组翻转链表

import java.util.ArrayDeque;

/** 力扣234题 https://leetcode.cn/problems/palindrome-linked-list/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode node1;
        ListNode node2;
        while(head!=null){
            deque.add(head);
            head=head.next;
        }
        while (!deque.isEmpty()){
            node1=deque.pollFirst();
            node2=deque.pollLast();
            if(deque.isEmpty()&&(node1==null||node2==null)){
                return true;
            }
            if(node1.val!= node2.val){
                return false;
            }
        }
        return true;
    }

    ListNode left;
    public boolean isPalindrome1(ListNode head) {
        left=head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if(right==null) return true;
        boolean res=traverse(right.next);
        res=res&&(right.val==left.val);
        left=left.next;
        return res;
    }
}
