class Solution {
    
    // we have a prev/parent 
    public boolean validTree(int n, int[][] edges) {
        
        List<List<Integer>> graph=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>(); 
        
        for (int i=0; i < n; i++){
            graph.add(new ArrayList<>()); 
            
        }
        
        for (int[] e: edges){
            graph.get(e[0]).add(e[1]); 
            graph.get(e[1]).add(e[0]);    
        }
        int[] visited=new int[n]; 
        return dfs(set, graph, -1, 0) && set.size() == n;
        
    }
    
    
    boolean dfs(HashSet<Integer> set, List<List<Integer>> graph, int prev, int curr){
        if(set.contains(curr)) return false; 
        set.add(curr); 
        for (int neighbor: graph.get(curr)){
            if ( prev != neighbor){

            boolean result=dfs(set, graph, curr, neighbor); 
            if (!result) return false;    
            }                
            }
             return true; 
        
        }
    
    
   
        
        
    
}