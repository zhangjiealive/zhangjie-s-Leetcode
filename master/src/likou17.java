package likou;

import java.util.LinkedList;
import java.util.List;

public class likou17 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        else if(list2==null){
            return list1;
        }
        if(list1.val< list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        else {
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 =new ListNode(4);
        ListNode l2 =new ListNode(2,l1);
        ListNode l3 =new ListNode(1,l2);
        ListNode l4 =new ListNode(4);
        ListNode l5 =new ListNode(3,l4);
        ListNode l6 =new ListNode(1,l5);
        likou17 likou17 = new likou17();
        likou17.mergeTwoLists(l3,l6);
    }
}
