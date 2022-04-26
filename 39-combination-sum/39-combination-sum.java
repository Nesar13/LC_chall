class Solution {
    

        
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res=new ArrayList(); 
        List<Integer> temp=new ArrayList<>();
        backtrack(candidates, target, res, temp, 0, 0); 
        
        return res; 
  
    }
    
    
    void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int currSum, int start ){
        
        if (currSum==target) res.add(new ArrayList<>(temp)); 
        
        if (currSum > target) return; 
        
        for (int i=start; i< candidates.length; i++){
            
            int curr=candidates[i]; 
            temp.add(curr); 
            currSum+=curr; 
            backtrack(candidates, target, res, temp, currSum, i); 
            
            currSum -= curr; 
            temp.remove(temp.size()-1); 
        }
        
    }
        
   
        
    
}