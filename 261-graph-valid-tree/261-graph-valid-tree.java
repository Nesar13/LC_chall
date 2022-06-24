class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        //
        HashSet<Integer> visited=new HashSet<>(); 
        
        List<List<Integer>> graph=new ArrayList<>();
        
        for (int i=0; i < n; i++){
            
            graph.add(new ArrayList<>()); 
        }
        
        for (int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); 
            
        }
        
        return dfs(graph, visited,0, -1 ) && visited.size()==n; 
        
    }
    
    
    
    boolean dfs(List<List<Integer>> graph, HashSet<Integer> visited, int curr, int prev) {
        if(visited.contains(curr)) return false; 
        
        visited.add(curr); 
        
        for (int neighbor: graph.get(curr)){
            
            if(prev != neighbor){
                boolean result=dfs(graph, visited, neighbor, curr); 
                if (!result) return false; // if dfs was false
            }
        }
        
        return true; 
        
    }
}