public class Lc19_RemoveNthNodeLinkedList {

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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
// if head is null or if there is only one node return null because if there is just one node that
        // would be removed
        if(head == null || head.next == null)return null;
// temp1 for traversing the LL
// temp2 will move forward only when temp1 has moved n steps so temp2 is always n steps
// back from the end
        ListNode temp1 = head;
        ListNode temp2 = null;

//count to see how many steps temp1 has taken if count >n then start moving temp2
        int count =0;
        while(temp1!=null){
            count++;
            if(count>n){
                if(temp2 == null){
                    temp2 =head;
                }
                else{
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
        }

        //if temp2 is null that means first element has to be removed (dry run and see) so we return head.next
        if(temp2 == null){
            return head.next;
        }
        //else we remove the nth node from the last and return the original head
        temp2.next = temp2.next.next;
        return head;
    }

    public static void main(String[] args) {

        ListNode head=new ListNode(5);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode (2);


        System.out.println(removeNthFromEnd(head, 2));

    }

}
