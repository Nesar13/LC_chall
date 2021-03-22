public class Lc62_FindPeakElement_M {

    // an array will have many peaks, we just need to find one
    // binary
    public static int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(findPeakElement2(arr));


    }

    public int findPeakElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int resIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {

                max = nums[i];
                resIndex = i;

            }

        }

        return resIndex;


    }
}
