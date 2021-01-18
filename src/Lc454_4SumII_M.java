import java.util.HashMap;

public class Lc454_4SumII_M {


    // put the sum of each A+B into hashmap,
    // and increment it by 1 if it already exists
    // check if the inverse sum of C+B exists already in the hashmap and add it to a count
    // if it exists with the value of the key
    // O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <B.length ; j++) {
                map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);

            }

        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length ; j++) {
                int sum=-(C[i]+D[j]);
                if (map.containsKey(sum)){
                    // add the value of the key as well since it indicates the number of combinations
                    count+=map.get(sum);

                }
            }

        }
return count;
    }


    public static void main(String[] args) {

    }


}
