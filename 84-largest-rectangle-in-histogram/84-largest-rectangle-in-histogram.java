class Solution {
    
    // we want to keep an increasing monotonic stack
    public int largestRectangleArea(int[] heights) {
        
        if(heights.length==0) return 0; 
        
        // 1 2 3 4 5 6 3 <--notice that each number can be extended to the right
        //5 4 3 <-- notice that we can't extend 5 or 4 to the right, so we should calculate
        // max area and pop them
        
        ArrayDeque<int[]> stack=new ArrayDeque<>(); 
        int res=-1; 
        
        for (int i=0; i < heights.length; i++){
            
            // if we encounter something like this 4,3, we need to pop 4, but since
            // 3 can extend we have to use 4's index since 3 can extend backwards
            int currIndex=i; 
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] prevHeight=stack.poll(); 
                
                int prevIndex=prevHeight[0]; 
                
                res=Math.max(res, (i-prevIndex) * prevHeight[1]); 
                currIndex=prevIndex; // changed the currIndex since curr can extend backwards
            }
            
            stack.push(new int[]{currIndex, heights[i]}); 
        }
        
        // we may have a case where we don't remove some values as they are 
        // lower than neighbor or increasing
        //index:    1 4 5
        //          1 2 3
        while(!stack.isEmpty()){
            int[] curr=stack.poll(); 
            res=Math.max(res, (heights.length-curr[0])*curr[1]); 
            
            
        }
        return res; 
        
    }
}