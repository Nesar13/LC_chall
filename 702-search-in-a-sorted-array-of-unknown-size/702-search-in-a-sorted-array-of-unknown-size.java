/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int left=0; 
        int right=1; 
        while(reader.get(right) < target) right= right << 1; 
        
        while (left <= right){
            int mid=left+(right-left)/2; 
            
            int curr=reader.get(mid); 
            if (curr == target) return mid;
            if(curr == Integer.MAX_VALUE) right=mid-1; 
            else if(curr < target) left=mid+1; 
            else right=mid-1; 
            
            
        }
        
        
        return -1; 
        
    }
}