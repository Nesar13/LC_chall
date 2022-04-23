class Solution {
//     public int[] twoSum(int[] numbers, int target) {
        
//         int[] res=new int[2]; 
//         int left=0, right=numbers.length-1;
//         while (left < right ) {
//             int sum=numbers[left]+numbers[right]; 
            
//             if(sum==target) return new int[]{left+1, right+1}; 
           
//             if(sum > target) right--; 
//             else left++; 
            
//         }
        
//         return res; 
//     }
    
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }
}