public class Lc1423_MaximumPointsFromCards_M {

    // 100% we add up all the values to k-1 from left side
    // afterwards we subtract the the last digit in this window and add the right side
    public static int maxScore(int[] cardPoints, int k) {
        int ans = 0, leftCounter = 0, rightcounter = 0;
        int len = cardPoints.length;
        int x = k-1;
        for (int end = 0; end < k; end++) {
            leftCounter += cardPoints[end];

        }
        ans = leftCounter;
        for (int end = len - 1; end > len - 1 - k; end--) {

            rightcounter += cardPoints[end];
            //updating leftcounter by subtracting the previous value
            leftCounter -= cardPoints[x--];
            ans = Math.max(ans, leftCounter  + rightcounter);



        }
        return ans;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 1}; // answer should be

        System.out.println(maxScore(arr, 3));

    }
}
