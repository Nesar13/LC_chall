public class Lc287_FindingDuplicateNumber {


    public static int findDuplicate(int[] nums) {
        int[] arr= new int[nums.length+1];

        for (int i = 0; i <nums.length ; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]]==2)return nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr={1,1,2};

        System.out.println(findDuplicate(arr));
    }
}
