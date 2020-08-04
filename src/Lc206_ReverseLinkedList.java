import java.util.HashMap;
import java.util.List;

public class Lc206_ReverseLinkedList {


    public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Reversing a LinkedList using HashMap to store values, very slow
     * Runtime: 1 ms, faster than 9.43%
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
    ListNode dummy=null;
    HashMap<Integer, Integer> map=new HashMap<>();

    int count=0;
   /* dummy.next=head;*/
  /*  ListNode res=dummy.next*/;

    while(head !=null) {
        map.put(count++, head.val);
        head=head.next;



    }
ListNode curr=new ListNode(0);
    dummy=curr;
    while(count > 0) {

        curr.next= new ListNode(map.get(count-1));

      curr=curr.next;



        count--;
    }

    return dummy.next;
    }

    /**
     * Changing references of the given ListNode to previous Nodes
     * Runtime: 0 ms, faster than 100.00%
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        //prev keeps track of previous nodes, and will be returned at end
        //it will be initialized to null to set the of the head to null
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //this will keep track of the next node
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
int count=0;
HashMap<Integer, Integer> map=new HashMap<>();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
       /* for (int i = 0; i < 6; i++) {
            head.next=new ListNode(i);
            head=head.next;
        }*/


       /* System.out.println(head);*/
        System.out.println(reverseList2(head));

    }
}
