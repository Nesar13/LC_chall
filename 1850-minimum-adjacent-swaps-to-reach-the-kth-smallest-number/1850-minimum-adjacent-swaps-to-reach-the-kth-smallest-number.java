class Solution {
     public int getMinSwaps(String num, int k) {
        int N = num.length();
        int[] orig = new int[num.length()];
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
            orig[i] = num.charAt(i) - '0';
        }
        while (k-- > 0) nextPermutation(nums);
        int res = 0;
        for (int i = 0; i < N; i++)
            if (nums[i] != orig[i]) {
                int j = i;
                while (nums[j] != orig[i]) // we're trying to find where orig[i] is in our nums so we can swap it
                    j++;
                for (int x = j; x > i; x--) {
                    swap(nums, x, x - 1); // x-1 previous value
                    res++;
                }
            }
        return res;
    }
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; 
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) 
                j--; 
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right)
            swap(nums, left++, right--);
    }
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}