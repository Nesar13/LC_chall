public class Lc704_BinarySearch {
    public static int search(int[] nums, int target) {

        int hi=nums.length-1;
        int mid;
        int low=0;
        if (nums[0]==target) return 0;
      while (low <= hi){
          mid=low + (hi-low)/2;
          if (target == nums[mid]) {
              return mid;
          }
          else if (target > nums[mid]) {
              low =mid+1;
          }
          else {
              hi=mid-1;
          }
      }

      return -1;

    }

    public static void main(String[] args) {
//Example 1:
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4

        System.out.println(search(new int[]{2,5}, 5));
    }
}
