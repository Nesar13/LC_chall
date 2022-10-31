class Solution {
    //using bitmask
   public int maxProduct(String s) {
      
      if(s.length() == 2) {
         return 1;
      }
      
      int n = s.length();
      char[] ch = s.toCharArray();
   
      //bitmask to the length map
      Map<Integer, Integer> bitMasktoLengthMap = new HashMap<>();
      
      //using bitmask , calculate all the bitmask for 1 to 2^N
      // 1, 2, 3,............2024 ( 2 ^ 11 )
      for(int bitmask = 1 ; bitmask< Math.pow(2, n) ;bitmask++){
          
          //find all the subsequence(s) in the string using bitmask
          StringBuilder subsequence = new StringBuilder();
          for(int j = 0; j < n; j++ ){
   
             //if one of the bit is set to 1, then append that character to the subsequence.
             if(( bitmask & (1 << j ) ) != 0) { 
                subsequence.append(ch[j]);  //constructing subsequence of different length
             }
          }
          
          //if the sequence constructed above is a palindrome,
         // then store the mask and its length .
          if(isPalindrome(subsequence.toString().toCharArray())){
             bitMasktoLengthMap.put(bitmask, subsequence.length());
          }
      }
      
      Set<Integer> allBitMasks = bitMasktoLengthMap.keySet();
      
      int maxProduct = Integer.MIN_VALUE;
      for( int mask1 : allBitMasks){
         
         for( int mask2 : allBitMasks){
   
            //product of lengths of 2 disjoint palindromic subsequence(s)
            //if product of AND operation is 0 then subsequnce(s) are DIS-JOINT
             if(( mask1 & mask2 ) == 0){
                int product = bitMasktoLengthMap.get(mask1) * bitMasktoLengthMap.get(mask2);
                maxProduct = Math.max(maxProduct, product);
             }
         }
      }
      
      
      return maxProduct;
   }
   
   private boolean isPalindrome( char[] chars ) {
      
      int i = 0;
      int j = chars.length - 1;
      
      if(i == j)
         return true;
      
      while(i < j){
         if(chars[i] != chars[j]){
            return false;
         }
         i++;
         j--;
      }
      
      return true;
   }
}