class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
     HashSet<Integer> visited=new HashSet<>(); 
        
        
        dfs(rooms, visited, 0); 
        
        return visited.size()==rooms.size() ? true : false; 
    }
    
    
    void dfs(List<List<Integer>> rooms, HashSet<Integer> visited, int curr){
        
        if (visited.contains(curr)) return; 
        visited.add(curr); 
        
        for (int next: rooms.get(curr)){ 
                dfs(rooms, visited, next); 
            }
        
        return; 
        }
        
        
      
    
}