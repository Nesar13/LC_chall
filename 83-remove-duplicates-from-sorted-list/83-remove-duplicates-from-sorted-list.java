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
    public ListNode deleteDuplicates(ListNode head) {
      if (head==null) return head; 
        ListNode dummy=head; 
      
        ListNode j=head.next; 
        ListNode i=head; 
        if (head.next == null) return head; 
        
        while(j != null){
            
          
            
            if (i.val==j.val){
                j=j.next; 
                if(j==null) {
                    i.next=null; 
                }
            }
            else{
                i.next=j;
                i=i.next; 
                j=j.next; 
                
            }
            
        }
        
        return dummy; 
        
    }
}