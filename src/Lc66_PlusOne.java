import java.util.Arrays;

public class Lc66_PlusOne {


    // 100 fast, my solution
    public static int[] plusOne(int[] digits) {
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            int overFlow = digits[digits.length - (i + 1)] + 1;
            if (overFlow < 10) {
                digits[digits.length - (i + 1)] = overFlow;
                break;
            }

            digits[digits.length - (i + 1)] = overFlow % 10;
            count++;


        }
        int[] arr2 = new int[count + 1];
        if (digits.length == count) {
            arr2[0] = 1;
            for (int i = 1; i < count + 1; i++) {
                arr2[i] = digits[i - 1];
            }
            return arr2;
        }

        return digits;
    }

    public static void main(String[] args) {

        int[] arr = {9, 9, 9, 9};

        System.out.println(Arrays.toString(plusOne(arr)));

        int[] copy = Arrays.copyOf(arr, arr.length + 1);

    }

    // 100 fast and 100 memory
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

}
