class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //                        0  1 2  3  4  5  6  7
        //Input: temperatures = [73,74,75,71,69,72,76,73]
        //      Output:         [1,1,4,2,1,1,0,0]
        // stack: 73(0),
        // ans: [0,0,0,0,0,0,0,0]
        // we notice that curr is 74 and stack.peek() is 73, which is smaller 
        // so we can pop it and add the difference in index to that index of 73
        // stack: 74,           curr: 75
        // ans: [1,0,0,0,0,0,0,0]
        
        //stack: 75             curr: 71
        // ans: [1,1,0,0,0,0,0,0]

        //stack: 75, 71, 69  <-- indication of a monotonic decreasing stack
        // ans: [1,1,0,0,0,0,0,0]
        
        //stack: 75, 71, 69     curr: 72
        // ans: [1,1,0,0,1,0,0,0] <-- replace 69's index(4) to 1 since 72 comes immediately after
        int[] res =new int[temperatures.length]; 
        ArrayDeque<Integer> stack=new ArrayDeque<>(); 
        
        
        for (int i=0; i < temperatures.length; i++){
            
            int curr=temperatures[i]; 
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < curr){
                
                int topIndex=stack.pop();
                
                res[topIndex]=i-topIndex;
                
            }
            stack.push(i); 
            
            
            
        }
        
        
        return res; 
        
    }
}