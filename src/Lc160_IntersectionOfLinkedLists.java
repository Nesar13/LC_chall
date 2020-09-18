public class Lc160_IntersectionOfLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // this is 100% fast
    // get the length of the linkedlists, truncate
    // so you start from the same index and eventually there will be a value that
    // matches
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int len1 = 0, len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = headA;
        p2 = headB;

        // this is used to make the same length
        // so you can go through the linkedlist with the same length
        if (len1 > len2) {
            for (int i = 0;i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0;i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    public static void main(String[] args) {

    }
}
