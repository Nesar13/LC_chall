class Solution {
    
    // bdca -> bca -> ba ->b
    public int longestStrChain(String[] words) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            set.add(word);
        }
        int res = 1;
        
        for (int i=0; i< words.length; i++) res=Math.max(res, backtrack(set, map,  words[i])) ; 
        
        return res; 
       
    }
    
    
    
    int backtrack(HashSet<String> set, HashMap<String, Integer> map, String curr){
        if (map.containsKey(curr)) return map.get(curr);
        
   
        int count=1; 
        for (int i=0; i < curr.length(); i++){
            String temp=curr.substring(0, i) + curr.substring(i+1); 
            if (set.contains(temp)) count=Math.max(count, 1+backtrack(set, map, temp));                                          
        }
        map.put(curr, count); 
        return count; 
    }
    
     
}