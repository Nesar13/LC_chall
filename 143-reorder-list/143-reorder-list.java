/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //find the two halves by using slow and fast pointer
    public void reorderList(ListNode head) {
        
        if(head ==null || head.next == null) return; 
        
        // find the first half, with fast and slow pointers
        ListNode slow=head; 
        ListNode fast=head.next; 
        
        while(fast != null && fast.next !=null){
            slow=slow.next; 
            fast=fast.next.next;  
        }
        
        // reverse the second half; 
        ListNode second=slow.next; 
        slow.next=null; 
        ListNode temp=second.next; 
        second.next=null; 
        
        // 1 -> 2 -> 3 4
        while (temp != null){
            ListNode temp2=temp.next; 
            temp.next=second;
            second=temp; 
            temp=temp2; 
            
        }
        
        
        // merge
        ListNode first=head; 
        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        
        
        
        
    }
}