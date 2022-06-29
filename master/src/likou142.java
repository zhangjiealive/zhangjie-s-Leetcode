
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class likou142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return null;
        ListNode replace=head;
        HashSet<ListNode> set = new HashSet<>();
        while(!set.contains(replace)&&replace.next!=null){
            set.add(replace);
            replace=replace.next;
            if(replace.next==null){
                return null;
            }
        }
        replace=head;
        for (int i = 0; i < set.size()-1; i++) {
            replace=replace.next;
        }
        while(replace.next!=head){
            head=head.next;
        }
        if(replace.next==head){
            return replace.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1=new ListNode(1,listNode);
        likou142 likou142 = new likou142();
        System.out.println(likou142.detectCycle(listNode1));
    }
}
