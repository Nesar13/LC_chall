class Solution {
    //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    //  Output: [3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res= new int[nums.length - k + 1]; // note that our size for result
        int j = 0; // counter for ans
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i < nums.length; i++){
            
            if(!q.isEmpty() && i-q.peekFirst()+1 > k) q.pollFirst(); // make sure we have at most k elements
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i] ) q.pollLast(); // removing nums less than curr
            q.offer(i); 
            if(i >= k-1) res[j++] =nums[q.peekFirst()];
            
        }
        
        return res; 
        
      
}
    
}
    

    