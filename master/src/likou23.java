package likou;

import java.util.List;

public class likou23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return new ListNode(0).next;
        ListNode big=lists[0];
        int i=0;
        for(;i< lists.length-1;){
            if(big==null&&lists[i+1]==null){
                i=i+2;
                big=lists[i];
                continue;
            }
            if(big==null){
                big=lists[i+1];
                i++;
                continue;
            }
            if(lists[i+1]==null){
                i++;
                continue;
            }
            if(big.val<lists[i+1].val){
                big=mergeTwoLists(big,lists[i+1]);
                i++;
            }
            else {
                big=lists[i+1];
                big=mergeTwoLists(big,lists[i+1]);
                i++;
            }
        }
        return big;
    }

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
}
