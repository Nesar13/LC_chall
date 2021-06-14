import java.util.Arrays;

public class Lc34_FindFirstAndLastPositionofElmentInSortedArray_M {

    // we do two binary searches to get the left side index and the right side
// we get the leftmost index by checking the immediate
// left index is equal to target, if so, we have to move the right pointer to mid-1
// since we have to do more work
// we do the opposite for the right side range
// O(logn)  time | O(1) space

    public static int[] searchRange(int[] nums, int target) {


        // do a binary search for the left side index
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);


        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                // check one index to the left
                // if equal to target number, we do another binary search

                if (mid - 1 >= 0 && nums[mid - 1] == target) {
                    // do another binary search

                    right = mid - 1;


                } else {
                    // we add the index on the left side
                    res[0] = mid;
                    break;
                }


            } else if (target < nums[mid]) right = mid - 1;

            else left = mid + 1;


        }

        // we can reduce the amount of work we do if we set the left
        // pointer to the left side range so we eliminate everything to the left

        //left= res[0] != -1 ? res[0] :0;
        left = 0;
        right = nums.length - 1;

        // do a binary search for the right side index
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                // check one index to the left
                // if equal to target number, we do another binary search

                if (mid + 1 < nums.length && nums[mid + 1] == target) {
                    // do another binary search on the right side

                    left = mid + 1;


                } else {
                    // we add the index on the right side
                    res[1] = mid;
                    break;

                }


            } else if (target < nums[mid]) right = mid - 1;

            else left = mid + 1;


        }


        return res;

    }


    public static void main(String[] args) {
        //[2,2]
        //2

        int [] arr={2,2};

        System.out.println(Arrays.toString(searchRange(arr, 2)));
    }
}
