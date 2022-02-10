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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode firstHalf=new ListNode(-1); 
        ListNode secondHalf=new ListNode(-1); 
        ListNode dummy=list1; 
        int count=0; 
        
        while (list1 != null){
            
            if (list1.next != null && count+1==a){ 
                ListNode temp=list1.next; 
                list1.next=null;
                list1.next=list2; 
                firstHalf.next=list1.next; 
                firstHalf=firstHalf.next; 
                list1=temp; 
                count++; 
            }
            if(list1.next != null && count==b) {
                ListNode temp=list1.next;
                list1.next=null; 
                while(firstHalf != null){
                    if (firstHalf.next==null) {
                        firstHalf.next= temp; 
                        break; 
                    }
                    firstHalf=firstHalf.next; 
                }
                
               break; 
            }
            
            list1=list1.next;   
            count++;
        }

        
        return dummy; 
        
    }
}