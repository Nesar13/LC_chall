class Solution {
    
 public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
        }

        for (int num : nums) {
            int curr=Math.abs(num); 
            if (nums[curr - 1] > 0) {
                ans.add(curr);
                nums[curr - 1] *= -1;
            }
        }

        return ans;
    }
}