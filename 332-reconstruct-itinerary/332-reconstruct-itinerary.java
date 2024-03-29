class Solution {
    
    //1)  we have to realize that we have to store adjacency list in 
    // hashmap where the key is source and the value is a list of destinations
    // since the problem requires you to go in sorted order, we have to 
    // sort the list in our hashmap
    // HashMap<String, List<String>>
    // 2) Then we have to use backtracking to generate all possible paths
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        List<String> res=new ArrayList<>(); 
        
    
        HashMap<String, List<String>> map=new HashMap<>(); 
        
        for (List<String> t: tickets){
            
            map.putIfAbsent(t.get(0), new ArrayList<>()); 
            map.get(t.get(0)).add(t.get(1)); 
        }
        
        for (String airport: map.keySet()){
            Collections.sort(map.get(airport)); 
        }
        
        dfs("JFK", map, res); 
        
        return res; 
        
    }
    
    
    private boolean dfs(String curr, HashMap<String, List<String>> map, List<String> res){
        
        if(map.keySet().size() ==0){
            res.add(curr); 
            return true; 
        }
        else if(!map.containsKey(curr)) return false; 
        
        for (int i=0; i < map.get(curr).size(); i++){
            String to=map.get(curr).get(i); 
            res.add(curr); 
            map.get(curr).remove(i); 
            if (map.get(curr).size()== 0) map.remove(curr);
            if(dfs(to, map, res)) return true; 
            map.putIfAbsent(curr, new ArrayList<String>()); 
            map.get(curr).add(i, to); 
            
            res.remove(res.size()-1); 
        }
        
        return false; 
    }
}