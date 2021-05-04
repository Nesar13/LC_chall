public class Lc134_GasStation_M {

    // we first check if the total gas-cost is a net positive, otherwise we return -1
    // then we check from the 0 index if we have net positives, or negatves
    // if negative, we increment our start index to be returned
    // if positive, we store the sum and go through the next index without incrementing start
    //
    // there's a proof that
    // O(N) SC: O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;
    }
    public static void main(String[] args) {
        //[5,8,2,8]
        //[6,5,6,6]
        //Output
        //1
        //Expected
        //3

        int [] arr1={5,8,2,8};
        int [] arr2={6,5,6,6};

        System.out.println(canCompleteCircuit(arr1, arr2));



    }
}
