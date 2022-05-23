class Solution {
    public int countComponents(int n, int[][] edges) {
        
        boolean[] visited=new boolean[n]; 
        List<List<Integer>> graph=new ArrayList(); 
        int res=0; 
        for (int i=0; i < n; i++){    
            graph.add(new ArrayList<>()); 
        }
        
        for (int[] e: edges){
            
            graph.get(e[0]).add(e[1]); 
            graph.get(e[1]).add(e[0]); 
            }
        
        for (int i=0; i < n; i++){
            
            if (visited[i]) continue; 
            
            dfs(graph, visited, i);
            res++; 
            
            
        }
        
        return res; 
        
    }
    
    
    
    void dfs(List<List<Integer>> graph, boolean[] visited, int curr){
        
        
        visited[curr]=true; 
        for (int neighbor: graph.get(curr)){
            if(visited[neighbor]) continue; 
            dfs(graph, visited, neighbor); 
        }
        
    }
}