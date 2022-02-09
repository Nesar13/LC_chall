class Solution {
    
    // 1) my first intuition was that we can perhaps to a smart precomputation
    // but i found out we can compute the geometric pattern
    // 2) We can get the min and max in a range, and add min and max and divide by the total nums -1
    // to get the geometric pattern
    // 3) Then we can use the pattern to remake the range if it is a geometric sequence by comparing
    // it to our original range in a set
    // O(n*m) time where n is length of l, and m is the total length of array
    // O(n) space if we use a hashset
      public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i = 0; i < l.length; i++) {
            res.add(isArithmeticSeq(nums, l[i], r[i]));
        }
        
        return res;
    }


private boolean isArithmeticSeq(int[] nums, int start, int end) {
    //If the subarray is size 1(never less because l[i] < r[i] is a given), it's an arithmetic sequence.
    if(end - start < 2) return true; 
    
    //The first goal is to find the maximum value and the minimum value in the subarray.
    //If the subarray is an arithmetic sequence, there should be an even gap between every consecutive index.
    int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

    //The order of the numbers doesn't matter, so we can use a set to hold all values of the subarray.
    //Add all values between the left and right indexes into the set.
    Set<Integer> set = new HashSet<Integer>();
    for(int i = start; i <= end; i++) {
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
        set.add(nums[i]);
    }
    
    //If we cannot even divide the difference between the max and min, we don't have an arithmetic sequence.
    //There needs to be an interval that we can add to each index to get the next number.

    //Example1 - SubArray(Not an arithmetic seq) = {5, 10, 15, 20, 27}
    //Max = 27, Min = 5, Start = 0, End = 4
    //Interval = (27 - 5) / (4 - 0) = 22 / 4 = 5.5

    //Example2 - SubArray(Arithmetic seq) = {5, 10, 15, 20, 25}
    //Max = 25, Min = 5, Start = 0, End = 4
    //Interval = (25 - 5) / (4 - 0) = 20 / 4 = 5

    if((max - min) % (end - start) != 0) return false;
    int interval = (max - min) / (end -start);
    
    //Because we know what the interval between each number must be, we can search the set to
    //to confirm whether or not it's in the subarray.
    for(int i = 1; i <= end -start; i++) {
        if(!set.contains(min + i * interval)) return false;
    }
    
    return true;
}

}