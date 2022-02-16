class Solution {
    public int minReorder(int n, int[][] connections) {
        
        boolean[] visited=new boolean[n]; 
        HashSet<Integer>[] graphs=new HashSet[n]; 
        
        Set<String> set=new HashSet<>(); 
        for (int i=0; i < n; i++){
            
            graphs[i]=new HashSet(); 
        }
        
        for (int i=0; i < connections.length; i++) {
            set.add(connections[i][0] +","+ connections[i][1]); 
            graphs[connections[i][0]].add(connections[i][1]); 
            graphs[connections[i][1]].add(connections[i][0]); 
            
        }
        
        
        Deque<Integer> q=new ArrayDeque(); 
        
        int res=0;
        q.offer(0);
        visited[0]=true; 
         
        while (!q.isEmpty()){
            
        
            int curr=q.poll(); 
                
                
                for (int nodes:  graphs[curr]){
                    
                    if (visited[nodes]) continue; 
                    visited[nodes]=true; 
                    if (!set.contains(nodes +","+ curr)) res++; //note if it is not 
                    q.offer(nodes); 
                }
                
               
                
            
            
        }
        
        return res; 
        
        
    }
}