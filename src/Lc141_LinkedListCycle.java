public class Lc141_LinkedListCycle {

    public static class ListNode {
     int val;
     ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
    }

    // 100% speed
    // Since it is a cycle, you have a fast pointer
    // and a slow pointer
    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if (head.next==null){ return false; }

        ListNode fastNode=head.next;
        ListNode slowNode=head;
        while(fastNode.val !=slowNode.val) {
           if(fastNode.next.next==null || slowNode.next==null) {
               return false;
           }
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode.next==null) {
                return false;
            }
        }
        return true;

    }



    // recursive solution
    public static boolean hasCycle2(ListNode head){
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        ListNode nextNode = head.next;
        // note that this points to itself
        head.next = head;
        boolean isCycle = hasCycle2(nextNode);
        return isCycle;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(3);
        head.next.next=new ListNode (4);

        head.next.next.next=new ListNode(7);
        head.next.next.next.next=head.next;

        System.out.println(hasCycle2(head));


    }
}
