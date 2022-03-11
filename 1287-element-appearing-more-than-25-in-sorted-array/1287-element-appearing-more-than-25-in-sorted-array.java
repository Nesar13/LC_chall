class Solution {
    public int findSpecialInteger(int[] arr) {
        
        if (arr.length==1) return arr[0]; 
        double x= arr.length * 0.25; 
        int amount= (int) x;  
        
        int count=1; 
        
        for (int i=1; i< arr.length; i++){
            if (arr[i-1]==arr[i]) {
                count++;
                if(count > amount) return arr[i]; 
            }
            else count=1; 
            
        }
        
        return -1; 
    }
}