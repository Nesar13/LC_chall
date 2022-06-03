class Solution {
   public List<List<Integer>>subsetsWithDup(int[] nums) {
                
                List<List<Integer>>res=new ArrayList<>();
                Arrays.sort(nums); // need to sort
                backtrack(res,new ArrayList<Integer>(),nums,0);
                return res;
        }
      void backtrack(List<List<Integer>>res,List<Integer>temp,int[] nums,int start){
                
                res.add(new ArrayList<>(temp));
                for(int i=start;i <nums.length;i++){
                        if(i>start &&nums[i]==nums[i-1])continue;// notice that we skip if i > start
                        temp.add(nums[i]);
                        backtrack(res,temp,nums,i+1);
                        temp.remove(temp.size()-1);
                }
                
        }
}