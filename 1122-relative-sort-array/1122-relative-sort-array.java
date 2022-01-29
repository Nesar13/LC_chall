class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] freq= new int[1001]; 
        
        int[] res=new int[arr1.length]; 
        for (int num: arr1){
            freq[num]++; 
        }
        
        int  count=0; 
        for (int i=0; i < arr2.length; i++){
            
            int curr=arr2[i]; 
            while(freq[curr]-- > 0) res[count++]=curr; 
            
        }
        
        for (int i=0; i < 1001; i++){
            
            while (freq[i]-- > 0) res[count++]=i; 
        }
        
        
        return res; 
        
        
    }
}