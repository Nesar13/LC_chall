public class Lc328_OddEvenLinkedList_M {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static ListNode oddEvenList(ListNode head) {

        if (head==null) return null;

        ListNode even= head.next;

        ListNode evenHead=even;
        ListNode odd=head;


        while(even != null && even.next != null) {

            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;

        }
        odd.next= evenHead;

        return head;


    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode (4);
//        head.next.next.next.next=new ListNode (5);

        System.out.println(oddEvenList(head));
    }
}
