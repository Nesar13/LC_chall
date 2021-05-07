public class Lc135_Candy_MinRewards_H {


    public static int candy(int[] ratings) {


        int rlen=ratings.length;
        if (rlen==1) return 1;
        if (rlen==0) return 0;
        if (rlen==2) return ratings[0]==ratings[1] ? 2 : 3;
        int [] res=new int[ratings.length];

        for (int i=0; i< rlen; i++){

            int r = ratings[i];
            res[i]=1;

            if (i==0) continue;

            else if (i==rlen-1) {res[i]= ratings[i] > ratings[i-1] ? Math.max(res[i], res[i-1]+1) : 1 ;
                continue;
            }
            // check if previous is same and next is same
            else if( r == ratings[i-1] && r==ratings[i+1]) continue;

                // check if previous is same and next is less, then we just have 2 as it's value
            else if(r == ratings[i-1] && r > ratings[i+1] ) res[i]=res[i]+1;
            else if(r == ratings[i-1] && r < ratings[i+1]) continue;

            else if(r <= ratings[i+1] && r > ratings[i-1] && i != rlen-1){
                res[i]=Math.max(res[i-1], res[i-1]+1);
            }
            else if( r > ratings[i+1] && r > ratings[i-1] && i != rlen-1) {

                res[i]=Math.max(res[i], res[i-1]+1);
            }


        }

        // going from right to left
        for (int i=rlen-1; i >= 0; i--){
            int r = ratings[i];

            if ( i==rlen-1) continue;
            else if (i==0 && r != ratings[i+1]) { res[i]= r >ratings[i+1] ? Math.max(res[i+1]+1, res[i]): res[i]; }
            else if (i==0 && r == ratings[i+1]) res[i]=1;
            //else  if( r > ratings[i-1]) continue;

            else if( r <= ratings[i-1] && r > ratings[i+1]) res[i]=Math.max(res[i], res[i+1]+1);
            else if( r >= ratings[i-1] && r > ratings[i+1]) res[i]=Math.max(res[i], res[i+1]+1);

            else if( r==ratings[i+1] && r < ratings[i-1]) continue;
            else if (r==ratings[i+1] && r > ratings[i-1] ) res[i]=Math.max(res[i], res[i-1]+1);




        }

        int sum=0;
        for ( int num: res) sum+=num;

        return sum;
    }

    public static void main(String[] args) {
       // int [] arr= { 1,0,2};
       // int [] arr= { 1,2,2};
       // int [] arr= { 1,2,87,87,87,2,1};
        int [] arr= { 1,6,10,8,7,3,2};

        System.out.println(candy(arr));
    }

}
