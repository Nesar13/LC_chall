import java.util.HashMap;

public class Lc136_SingleNumber {
    public int singleNumber(int[] nums) {

      int num=0;





        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];

        }


return num;
    }
    public static void main(String[] args) {

    }
}
