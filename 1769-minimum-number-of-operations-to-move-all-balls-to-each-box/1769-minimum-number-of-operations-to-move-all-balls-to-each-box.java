class Solution {
    //1xxx0
    //1110
    //11011
    //left 013
    
    //0011
    //10 - 1 move
    //110 - 3 moves
    //1110 - 6 moves ()
    //11110 - 4+3+2+1
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
    
    
   int getSum(int n){
        int temp=0;
        while (n >0)temp += n--; 
        
       return temp; 
    }
}