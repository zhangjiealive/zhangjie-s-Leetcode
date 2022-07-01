//: Leetcode160.java

import java.util.HashSet;
import java.util.List;

/** 力扣160. 相交链表 https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> objects = new HashSet<>();
        while(headA!=null){
            objects.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if(objects.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            if(p1==null){
                p1=headB;
            }
            else {
                p1=p1.next;
            }
            if(p2==null){
                p2=headA;
            }
            else {
                p2=p2.next;
            }
        }
        return p1;
    }
}
