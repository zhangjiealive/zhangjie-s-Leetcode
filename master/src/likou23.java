
import java.util.List;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> {
            return (a.val - b.val);
        });
        for (ListNode a :
                lists) {
            if(a!=null) {
                pq.add(a);
            }
        }
        while (!pq.isEmpty()){
            ListNode node=pq.poll();
            p.next=node;
            if(node.next!=null){
                pq.add(node.next);
            }
            p=p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        likou23 likou23 = new likou23();
        ListNode l8 = new ListNode(6);
        ListNode l7 = new ListNode(2,l8);
        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3,l6);
        ListNode l4 = new ListNode(1,l5);
        ListNode l3 = new ListNode(5);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(1,l2);
        ListNode[] listNodes={null};
        likou23.mergeKLists1(listNodes);
    }
}
