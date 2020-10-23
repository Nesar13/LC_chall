public class Lc11_ContainerWitMostWater_M {

    public static int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right= height.length-1;
        for (int i = 0; i <height.length ; i++){
            //choose max between current max and new max
            //height is the min height between the rectangles
            max= Math.max(max,(right-left)*Math.min(height[left], height[right]));//area formula
            if ( height[left]<height[right]){//change pointer for the one that is smaller height
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static int maxArea1( int[] height){

        int area=0;

        int [] dp = new int[height.length];

        dp[0]=height[0];

        for (int i = 1; i < height.length; i++) {

            int min=Math.min(height[i], height[height.length-i]);
            dp[i]= Math.max(min*height[i], dp[i]);

        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <dp.length ; i++) {
            max=Math.max(max, dp[i]);


        }

        return max;


    }

    public static void main(String[] args) {

        int[] arr= {1,8,6,2,5,4,8,3,7};


        System.out.println(maxArea(arr));

    }
}
