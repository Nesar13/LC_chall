import java.util.HashMap;

public class Lc206_ReverseLinkedList {


    public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode reverseList(ListNode head) {
    ListNode dummy=new ListNode(0);
    HashMap<Integer, Integer> map=new HashMap<>();

    int count=0;
    head=dummy;

    while(head!=null) {
        head=head.next;
        count++;
        map.put(count, head.val);

    }

    while(count >= 0) {

        dummy=new ListNode(map.get(count));

        dummy=dummy.next;

        count--;
    }

    return dummy;
    }

    public static void main(String[] args) {

    }
}
