import java.util.Arrays;

public class Lc283_MoveZeros {


    public static void moveZeroes(int[] nums) {
        int start = 0;
        int countZeros = 0;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                //Swapping all the non-zero values to the beginning of the array
                nums[start++] = nums[i];
            } else
                //otherwise we want to count the zeros for later
                countZeros++;
        }

        while (countZeros != 0) {
            //adding the zeros at the end of the list
            nums[end - countZeros] = 0;

            countZeros--;
        }



    }

    public static void main(String[] args) {


        int[] arr = {0, 1, 0, 3, 12};

        /*System.out.println(moveZeroes(arr));*/
    }
}
