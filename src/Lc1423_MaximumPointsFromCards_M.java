public class Lc1423_MaximumPointsFromCards_M {

    public static int maxScore(int[] cardPoints, int k) {
int ans = 0, leftCounter = 0,  rightcounter=0;
int len=cardPoints.length;
int x=k-1;
        for (int end = 0; end < k; end++) {
            leftCounter += cardPoints[end];

        }
        ans= leftCounter;
        for (int end = len-1; end > len-1-k ; end--) {

            rightcounter+= cardPoints[end];
            ans=Math.max(ans, leftCounter-cardPoints[x--]+rightcounter);
            if (ans > leftCounter) {
                leftCounter -= rightcounter;

            }


        }
        return ans;
    }


    public static void main(String[] args) {

    int[] arr= {1,2,3,4,5,6,1};

        System.out.println(maxScore(arr, 3));

    }
}
