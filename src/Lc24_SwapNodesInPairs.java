import java.util.List;

public class Lc24_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode root = new ListNode(0);

        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);

        System.out.println(swapPairs(root));
        // o 1 2 3 4
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, a = head, b = a.next, pre = null;
        while (a != null && b != null) {
            a.next = b.next;
            b.next = a;
            if (pre != null) pre.next = b;
            if (a.next == null) break;
            b = a.next.next;
            pre = a;
            a = a.next;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
