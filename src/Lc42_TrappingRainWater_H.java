public class Lc42_TrappingRainWater_H {

    // we just have to calculate the left max of a given index and right max
// we do that by storing it in two arrays
// TC: O(n) SC: O(n)..could potentially have a space complexity of O(1)

    public int trap(int[] height) {
        int len=height.length;

        int [] leftMax=new int[len];
        int [] rightMax = new int[len];
        int [] water=new int[len];

        int r=Integer.MIN_VALUE;
        int l=Integer.MIN_VALUE;

        for(int i=0; i< len; i++){
            l=Math.max(l,height[i] );
            leftMax[i]=l;

        }
        // note we start at the right
        for(int i=len-1; i>=0; i--){
            r=Math.max(r,height[i] );
            rightMax[i]=r;

        }
        int res=0;
        for(int i=1; i< len; i++){



            int temp=Math.min(leftMax[i], rightMax[i]);
            water[i]=temp - height[i];

            res+=water[i];

        }

        return res;


    }
}
