public class Lc61_RotateList_M {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) {
            return head;
        }
        // we start counting at 1 since we start at head
        int l=1;
        ListNode temp=head;

        // get the length of the LL
        // notice that we put temp.next instead of temp
        // because we don't want temp to equal to null

        while (temp.next != null) {
            temp=temp.next;
            l++;
        }

        // for large Ks we want to do minimum work
        int n=k%l;
        if (n==0) return head;

        int tail= l - (n);

        // get the tail node
        int count=1;
        ListNode tailNode=head;
        while (count != tail) {

            tailNode=tailNode.next;
            count++;
        }


        // get the head node
        ListNode newHead=tailNode.next;

        // point tail node to null;
        tailNode.next=null;


        //point the newHead's ending node to the beginning
        temp.next=head;
        return newHead;



    }
    public static void main(String[] args) {

    }

    private class ListNode {
        public ListNode next;
    }
}
