public class Lc142_LinkedListCycle_M {

      class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
      }

// algoexpert question H18. Find start of Loop
    // we basically do a fast and slow pointer to find where we coincide
    // then we calculated the remaining distance would be equal to the starting distance
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                // we have another pointer at the start
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }

        }
        return null;
    }
}
