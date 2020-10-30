import java.util.Arrays;
import java.util.Random;

public class Lc215_KthLargestElementInArray_M {

    // QuickSelect Solution
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickselect(nums, 0, len - 1, len + 1 - k);
    }

    private static int quickselect(int[] nums, int s, int e, int n) {
        int random = new Random().nextInt(e - s + 1) + s;
        swap(nums, random, s);
        int pivot = nums[s], p1 = s;
        for (int i = s + 1; i <= e; i++) {
            if (nums[i] < pivot) {
                p1++;
                swap(nums, p1, i);
            }
        }
        swap(nums, s, p1);
        if (p1 == n - 1) {
            return pivot;
        } else if (p1 > n - 1) {
            return quickselect(nums, s, p1 - 1, n);
        } else {
            return quickselect(nums, p1 + 1, e, n);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(arr, 2));
    }


}
