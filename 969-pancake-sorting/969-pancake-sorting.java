class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res=new ArrayList<>(); 
        if(arr.length==0 || arr.length==1) return res; 
        if (isSorted(arr)) return res; 
      
        for (int i=arr.length-1; i >=0; i--){
            
            int index=findMax(arr, i); 
            reverse(arr, index); 
            reverse(arr, i); 
            res.add(index+1); 
            res.add(i+1); 
        }
        return res; 
    }
    
    
    int findMax(int[] arr, int end){
        int max=arr[0];
        int index=0; 
        for (int i=0; i <= end; i++ ) {
            if(arr[i] > max){
                max=arr[i]; 
                index=i; 
            }
        }    
        return index; 
    }
    
    
    
    void reverse(int[] arr,int end){
        int left=0; 
        int right=end; 
        while(left < right) {
            
            int temp=arr[left]; 
            arr[left]=arr[right]; 
            arr[right]= temp; 
            left++; 
            right--; 
        }
    }
    
    boolean isSorted(int[] arr){
        for (int i=0; i < arr.length-1; i++){
            if (arr[i] > arr[i+1]) return false;
        }
        return true; 
    }
    
    
    
}