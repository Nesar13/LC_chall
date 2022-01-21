class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> res=new ArrayList<>(); 
        
        int max=0; 
        
        for (int c: candies){
            if (c > max) max=c; 
        }
        
        for(int c: candies){
            
            if (c+extraCandies >= max)res.add(true); 
            else{
                res.add(false); 
            }
            
        }
        return res; 
    }
}