class Solution {
    
    
  
    // 1) I intially thought we can store the ranges, but I didn't know how to implement it
    // 2) The trick is to add the increment to the start value and subtract the increment
    // from the end+1 index
    // 3) aftwards, you do a running sum and set each sum to our array
    // so the ith index should be the sum of all the times this was updated
    // lenght: 5
    //Input: [[1,3,2],[2,4,3],[0,2,-2]]
    // 0 1 2 3 4
    // 0 0 0 0 0
    //   2    -2
    //     3  
    // -2    2
    // -2 0 3 5 3  <- output
    // O(n+k) where n is length of array, and k is the length of the given updates
    // O(1) time
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], val = update[2];
            res[start] += val;
            if (end < length - 1) res[end + 1] -= val;
        }
        int cur = 0;
        // "range caching"
        for (int i = 0; i < length; i ++) {
            cur += res[i];
            res[i] = cur;
        }
        return res;
    }

}