class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //Input: wall = 
//         [[1,2,2,1],
//          [3,1,2],
//          [1,3,2],
//          [2,4],
//          [3,1,2],
//          [1,3,1,1]]
        
//         -#--#--#-
//         ---#-#--
        int n=wall.size(); 
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for (List<Integer> l : wall){
            int curr=0; 
            
            for (int i=0; i < l.size()-1; i++){
                curr += l.get(i); 
                map.put(curr, map.getOrDefault(curr, 0) + 1); 
            }
            
        }
        
        int min=n;  
        
        for (int i: map.keySet()){
           // if(i==n) continue; 
            min=Math.min(n-map.get(i), min); 
            
        }
        
        return min; 
        
    }
}