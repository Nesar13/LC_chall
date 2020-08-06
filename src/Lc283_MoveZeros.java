import java.util.Arrays;

public class Lc283_MoveZeros {


    public static void moveZeroes(int[] nums) {
        int start = 0;
        int countZeros = 0;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[start++] = nums[i];
            } else
                countZeros++;
        }

        while (countZeros != 0) {

            nums[end - countZeros] = 0;

            countZeros--;
        }



    }

    public static void main(String[] args) {


        int[] arr = {0, 1, 0, 3, 12};

        /*System.out.println(moveZeroes(arr));*/
    }
}
