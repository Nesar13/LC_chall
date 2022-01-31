class Solution {
       public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i=0; i < l.length; i++) {
            res.add(checkIsArithmeticSubarrays(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }
        return res;
    }
    
    public boolean checkIsArithmeticSubarrays(int[] nums) {
        if (nums.length < 2) return false;
        if (nums.length == 2) return true;
        Arrays.sort(nums);
        int delta = nums[1]-nums[0];
        for (int i=1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] != delta) return false;
        }
        return true;
    }
}