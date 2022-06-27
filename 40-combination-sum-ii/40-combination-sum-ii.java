class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates); 
        List<List<Integer>> res=new ArrayList<>(); 
        
        backtrack(candidates, target, 0,res, new ArrayList<Integer>(), 0 ); 
        
        return res; 
        
    }
    
    void backtrack(int[] candidates, int target, int sum, List<List<Integer>> res, List<Integer> temp ,int start){
        if(sum==target) {
            res.add(new ArrayList<>(temp));
            return; 
        }
        if(sum > target) return; 
        for(int i=start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue; 
            
            temp.add(candidates[i]); 
            backtrack(candidates, target, sum+candidates[i], res, temp, i+1); 
          
            temp.remove(temp.size()-1); 
            
            
        }
        
    }
}