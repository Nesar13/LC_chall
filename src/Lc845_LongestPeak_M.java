import java.util.Arrays;

public class Lc845_LongestPeak_M {
    public static void main(String[] args) {

        //candies = 7, num_people = 4
        System.out.println(Arrays.toString(distributeCandies(60, 4)));
    }



    // the first step is to find a peak, and then traverse the left
    // and right side of the peak to find a length
    // you traverse left side by checking if it is strictly decreasing
    // you traverse the right side by checking if it is also strictly decreasing
    // TC: O(N) since we only traverse each values 2 or three times so like O 2N
    // SC: O(1)
    public int longestMountain(int[] arr) {

        int longestPeak = 0;
        int i = 1;
        int len = arr.length;

        while (i < len - 1) {

            boolean isPeak = arr[i - 1] < arr[i] && arr[i] > arr[i + 1];
            if (!isPeak) {
                i++;
                continue;

            }
            int left = i - 2;
            while (left >= 0 && arr[left] < arr[left + 1]) {
                left--;

            }
            int right = i + 2;
            while (right < len && arr[right] < arr[right - 1]) right++;
            int tempLength = right - left - 1;
            longestPeak = Math.max(longestPeak, tempLength);

            i++;

        }
        return longestPeak;


    }

    public static int[] distributeCandies(int candies, int num_people) {

        int [] res=new int[num_people];

        int count=1;
        int i=0;
        int totalSum=0;
        while (totalSum <=candies ){
            i = i % num_people;
            int left=candies-totalSum;
            if(count>left)  res[i]=res[i]+left;
            else res[i]=res[i]+count;

            totalSum=totalSum+count;

            count++;

            i++;


        }
        return res;
}
}
