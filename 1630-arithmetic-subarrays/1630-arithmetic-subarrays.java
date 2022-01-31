class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            int strt = l[i];
            int end = r[i];
            int[] arr = new int[end-strt+1];
            int k=0;
            for(int j=strt; j<=end; j++){
                arr[k++] = nums[j]; 
            }
            list.add(isArithmetic(arr));
        }
        return list;
    }
    private boolean isArithmetic(int[] arr){
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i=1; i<arr.length; i++)
            if(arr[i]-arr[i-1] != d)
                return false;
        return true;
    }
}