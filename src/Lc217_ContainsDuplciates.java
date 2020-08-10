import java.util.Arrays;
import java.util.HashMap;

public class Lc217_ContainsDuplciates {

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        for (int i = 0; i <nums.length ; i++) {
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return true;
        }

        return false;
    }

    public static int romanToInt(String s) {
        int n = 0;
        char prev = ' ';
        for (byte i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n += getValue(c, prev);
            prev = c;
        }

        return n;
    }

    private static int getValue(char c, char prev) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return prev == 'I' ? 3 : 5;
            case 'X':
                return prev == 'I' ? 8 : 10;
            case 'L':
                return prev == 'X' ? 30 : 50;
            case 'C':
                return prev == 'X' ? 80 : 100;
            case 'D':
                return prev == 'C' ? 300 : 500;
            case 'M':
                return prev == 'C' ? 800 : 1000;
        }

        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] nums= { 1,2,3,4};

        System.out.println(containsDuplicate(nums));

        byte[] bytes= {25,30,55,10};

        System.out.println(Arrays.toString(bytes)) ;

        System.out.println(5 << 90);

        System.out.println(romanToInt("IIX"));
    }


}
