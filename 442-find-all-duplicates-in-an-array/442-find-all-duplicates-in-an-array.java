class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
       
    
        List<Integer> res=new ArrayList<>(); 
        if (nums.length==0) return res; 
        int[] arr=new int[nums.length+1]; 
        
        for (int num: nums){
            arr[num]++; 
        }
        
        for (int i=0; i< nums.length+1; i++){
            
            if (arr[i] > 1) res.add(i); 
        }
        return res; 
    }
}