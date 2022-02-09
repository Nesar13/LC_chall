class Solution {
    public List<String> summaryRanges(int[] nums) {
        
//         List<String> res=new ArrayList<>(); 
//                 if (nums.length==0) return res; 

//         int cache=Integer.MIN_VALUE; 
//         StringBuilder sb=new StringBuilder();
//         boolean buildRange=false; 
       
//         for (int i=0; i< nums.length-1; i++){
            
//             if (nums[i] != nums[i+1] - 1 ) {
//                 sb.append(nums[i]); 
//                 res.add(sb.toString()); 
                
//                 sb=new StringBuilder(); 
//                 buildRange=false; 
                
//             }
//             // if nums are increasing by 1
//             else {
                
//                 if (!buildRange){
//                     sb.append(nums[i]); 
//                     sb.append("->"); 
//                     buildRange=true; 
                    
//                 }
             
                
                
                
//             }
            
            
            
            
//         }
        
//         if (buildRange ){
//             sb.append(nums[nums.length-1]); 
//             res.add(sb.toString()); 
//         }
//         else res.add("" + nums[nums.length-1]);

        
//         return res; 
        
//     }
        List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
        int start = nums[i];
        while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) i++;
        sb.append(start);
        if (nums[i] != start) sb.append("->").append(nums[i]);
        res.add(sb.toString());
        sb.setLength(0);
    }
    return res;
    }
}