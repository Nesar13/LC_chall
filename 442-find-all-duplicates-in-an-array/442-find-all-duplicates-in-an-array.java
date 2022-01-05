class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
       
    
        List<Integer> res=new ArrayList<>(); 
        int len=nums.length; 
        if (len==0) return res; 
        int[] arr=new int[len+1]; 
        
        for (int num: nums){
            arr[num]++; 
        }
        
        for (int i=0; i< len+1; i++){
            
            if (arr[i] > 1) res.add(i); 
        }
        return res; 
    }
}