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
    public ListNode middleNode(ListNode head) {
        
        if (head.next==null) return head; 
        //count the number of nodes
        ListNode temp=head;
        int len=0; 
        
        while (temp != null){
            
            len++; 
            temp=temp.next; 
            
        }
        
        
        int middle=len/2 +1; 
        
        System.out.println(middle);
        
        while ( middle > 1){
          
          
            head=head.next; 
            middle--; 
        }
        
        
        return head; 
        
        
    }
}