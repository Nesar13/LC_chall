public class Lc33_SearchinRotatedSortedArray_M {

    public static int search(int[] nums, int target) {

        int l=0;
        int r=nums.length-1;



        //[1,3,5], 6

        while (l <= r && r < nums.length)  {
            int m= l + (r-l)/2;
            int leftNum=nums[l];
            int rightNum=nums[r];
            int mid=nums[m];

            System.out.format(" %d, %d, %d %n" , l ,m, r );

            // for cases like [1], 2 input
            if(l==r && mid != target) return -1;
            if (leftNum==target) return l;
            if (rightNum==target) return r;


            if (target==mid) return m;
            else if (target <= mid) {
                if (target < mid && target >= leftNum) {
                    // search left
                    r=m-1;
                }
                else l=m+1;
            }

            else  {
                    l=m+1;
                   }


            System.out.format(" Second: %d, %d, %d %n" , l ,m, r );

        }

     return -1;



    }


    public static void main(String[] args) {
//[1,3,5]
//6
        //[4,5,6,7,8,1,2,3]
        //8

        int [] arr={4,5,6,7,8,1,2,3};

        System.out.println(search(arr, 8));
    }
}
