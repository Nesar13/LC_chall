class Solution {
  //
     private List<List<Integer>> result;
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        result = new ArrayList<>();
        int k = 4;                     //4 Sum
        kSum(nums, 0, target, k, new ArrayList<>());
        return result;
    }
    
     public void kSum(int[] nums,int start, int target, int k, List<Integer> list){
         
         if(k < 2) return;
         if(k == 2){
             twoSum(nums, target, start, list);
             
         } else {
             for(int i = start; i < nums.length - k + 1; i++){
                    if(i != start && nums[i] == nums[i-1]) continue;
                    list.add(nums[i]);
                    kSum(nums, i+1, target - nums[i], k - 1, list);
                    list.remove(list.size() - 1);
             }
         }
     }
   
    private void twoSum(int[] nums, int target, int l, List<Integer> list){
        int r = nums.length - 1;
        
        while(l < r){
            if(target < nums[l] + nums[r]){
                r--;
            } else if (target > nums[l] + nums[r]){
                l++;
            } else {
                list.add(nums[l]);
                list.add(nums[r]);
                result.add(new ArrayList<>(list));
                l++;
                
                while(l < r && nums[l] == nums[l-1]) l++; //Avoid duplicates
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }
        }
        
    }

}