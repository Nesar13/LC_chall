import java.util.Arrays;

public class Lc88_MergeSortedArray {


// compare the tails of each arrays, set the higher number at the end of num1
    // and decrement that tail
    // note that the space of num1 is m+n
    // edge case: for when tail2 is not finished add another while loop for the remaining
    // nums2...we also know that nums1 will finish after first loop since it is already in order
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }
        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int [] nums1= {1,2,3,0,0,0};

        int [] nums2= {4, 5, 6};

        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));
    }
}
