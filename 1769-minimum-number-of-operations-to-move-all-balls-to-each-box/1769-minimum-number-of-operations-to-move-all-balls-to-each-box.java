class Solution {
   
    //input:    11011
    //left:     01358
    //right:    85310 starting at right side
    //total:    86668 (left+right)
    //1) intially I thought it we should just keep track of the number 
    //  of balls in the left and right side using arrays
    //  but this method does not consider the relative position 
    //2)  We have to ask  ourselves how many total steps does it take for
    //  the balls to reach us
    // so we can keep track of the number of balls 
    // and add it to the current ith index along with the left value 
    // for the left array and the right value for the right array
    public int[] minOperations(String boxes) {
        
        int N=boxes.length(); 
        
        int[] left=new int[N]; 
        int[] right=new int[N]; 
        
        int balls= boxes.charAt(0) - '0'; 
        for (int i=1; i< N; i++){
            char c=boxes.charAt(i); 
            left[i] += left[i-1] + balls ;
           balls += c-'0';
            
        }
        balls= boxes.charAt(N-1) - '0';
        for (int i=N-2; i>=0 ; i--){
            char c=boxes.charAt(i); 
            right[i] +=right[i+1] + balls; 
            balls += c - '0'; 
            
        }
        
     

        int[] res=new int[N]; 
        
        for (int i=0; i <N; i++){
            res[i]= left[i]+right[i] ;
        }
        
        return res; 
        
        
        
    }
    
    
}