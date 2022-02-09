class Solution {
public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for(int i=0;i < arr.length; i++)
            ans += ((((arr.length-i) * (i+1)) + 1 )/2) * arr[i];
        return ans;
    }
}