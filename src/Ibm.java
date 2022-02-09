import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ibm {

    public static int minMoves(List<Integer> arr) {
        int noOfOnes = 0;
        int n= arr.size();
        // find total number of all in the array
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 1)
                noOfOnes++;
        }

        // length of subarray to check for
        int x = noOfOnes;

        int maxOnes = Integer.MIN_VALUE;

        // array to store number of 1's upto
        // ith index
        int preCompute[] = new int[n];

        // calculate number of 1's upto ith
        // index and store in the array preCompute[]
        if (arr.get(0) == 1)
            preCompute[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) == 1) {
                preCompute[i] = preCompute[i - 1] + 1;
            } else
                preCompute[i] = preCompute[i - 1];
        }

        // using sliding window technique to find
        // max number of ones in subarray of length x
        for (int i = x - 1; i < n; i++) {
            if (i == (x - 1))
                noOfOnes = preCompute[i];
            else
                noOfOnes = preCompute[i] - preCompute[i - x];

            if (maxOnes < noOfOnes)
                maxOnes = noOfOnes;
        }

        // calculate number of zeros in subarray
        // of length x with maximum number of 1's
        int noOfZeroes = x - maxOnes;

        return noOfZeroes;

    }

    public static void main(String[] args) {
        List<Integer> li= new ArrayList<Integer>(Arrays.asList(1,0,1,0,0,0,0,1));


       // System.out.println(minMoves(li));

        LinkedList <Integer> l=new LinkedList<>();

        l.add(1);
        l.add(3);
        l.add(4);

        System.out.println(l);
}}
