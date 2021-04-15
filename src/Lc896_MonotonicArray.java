public class Lc896_MonotonicArray {

    // we can just go through the array to see if it's increasing or decreasing
    // we set them to true for cases where we have [2222]
    // O(n) TC, O(1) SC
    public boolean isMonotonic(int[] A) {

        boolean decreasing=true;
        boolean increasing=true;

        for(int i = 1; i< A.length; i++){

            if (A[i] > A[i-1]) decreasing=false;
            if (A[i] < A[i-1]) increasing=false;
        }

        return decreasing || increasing;
    }
}
