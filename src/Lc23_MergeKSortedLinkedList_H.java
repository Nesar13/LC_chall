public class Lc23_MergeKSortedLinkedList_H {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    // basically we check the first node of each LL and get the min value
    // once we get the min value we add it to to our new LL,
    // and use the index of the min value LL to point to next node
    // so we can compare that next value with  the rest

    public static ListNode mergeKLists(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }

            }
            if (isBreak) {
                break;
            }
            ListNode a = new ListNode(lists[min_index].val);
            h.next = a;
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }
//  merge lists to the 0th list and then incrementing a variable by two times
    // to get the the merged list that we have not yet merged
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }
    // some f
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }


    public static void main(String[] args) {
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6


        ListNode root1=new ListNode(1);
        root1.next=new ListNode(4);
        root1.next.next=new ListNode(5);

        ListNode root2=new ListNode(1);
        root2.next=new ListNode(3);
        root2.next.next=new ListNode(4);

        ListNode root3=new ListNode(2);
        root3.next=new ListNode(6);

        ListNode [] input=new ListNode[] {root1, root2, root3};

        System.out.println(mergeKLists2(input));


    }
}
