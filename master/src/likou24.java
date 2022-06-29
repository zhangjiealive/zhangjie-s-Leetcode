package likou;

public class likou24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return new ListNode(0).next;
        if(head.next==null) return head;
        ListNode l=new ListNode(0,head);
        ListNode replaceh;
        ListNode replace=l;
        ListNode two;
        while (l.next!=null&&l.next.next!=null){
            if(l.next.next.next!=null){
                replaceh=l.next;
                two=l.next.next;
                replaceh.next=two.next;
                l.next=two;
                l.next.next=replaceh;
                l=l.next.next;
            }
            else {
                replaceh=l.next;
                two=l.next.next;
                l.next=two;
                l.next.next=replaceh;
                l=l.next.next;
                l.next=null;
            }
        }
        return replace.next;
    }

    public static void main(String[] args) {
        ListNode l4=new ListNode(4);
        ListNode l3=new ListNode(3,l4);
        ListNode l2=new ListNode(2,l3);
        ListNode l1=new ListNode(1,l2);
        likou24 likou24 = new likou24();
        likou24.swapPairs(l1);
    }
}
