class Solution {
    public boolean isPerfectSquare(int num) {
        // 16=4
        // 4/2=2
        // 36
        //a0
        
        // 
        if (num==1) return true; 
        long left =0; 
        long right=num/2; 
        
      while (left <= right){
          
          long mid=left+(right-left)/2; 
          long curr=mid*mid; 
          if(curr==num) return true; 
          if (curr < num) left=mid+1; 
          else if(curr > num) right=mid-1; 
          
      }
        
        return false;
        
    
}
}