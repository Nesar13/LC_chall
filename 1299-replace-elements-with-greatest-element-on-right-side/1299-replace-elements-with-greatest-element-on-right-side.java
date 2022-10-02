class Solution {
    
    // we just have to traverse from the right and keep track of max 
    // as we go to the left
    // O(n) time complexity | O(1) space
      public int[] replaceElements(int[] A) {
        int currMax = -1, n = A.length, a=0;
        for (int i = n - 1; i >= 0; --i) {
            a = A[i];
            A[i] =currMax;
           currMax = Math.max(currMax, a);
        }
        return A;
    }
}