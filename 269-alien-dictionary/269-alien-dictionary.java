class Solution {
    // words = ["wrt","wrf","er","ett","rftt"]
    // t -> f
    // w -> e
    // r -> t
    
    // keep track of indegree
    //   -we can have a cycle 
    //create a graph
    //  -use bfs to traverse graph
    //have visited characters
    // 
    public String alienOrder(String[] words) {
        
  
        Map<Character, HashSet<Character>> graph=new HashMap(); 
        int[] indegree=new int[26]; 
        //int[] outdegree=new int[26];
       
        
      // building the graph  
       for(String word :words) {
            for(char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }
        
        for(int i=0; i < words.length-1; i++){
            String first=words[i]; 
            String second=words[i+1]; 
                if (first.length() >second.length() && first.startsWith(second)) {
            return "";
        }
            
            int n=Math.min(first.length(), second.length()); 
            
            for (int j=0; j < n; j++){
                
                char parent=first.charAt(j); 
                char child=second.charAt(j); 
                
                if (parent == child) continue; 
                
                if(!graph.get(parent).contains(child)){
                graph.get(parent).add(child); 
                indegree[child-'a']++;
                //outdegree[parent - 'a']++; 
                }
                // set.add(a); 
                // set.add(b); 
                
                break; 
                
            }
            
            
        }
        
        // doing topological sort using BFS, using indegree
        // we will only add a character when it's indegree is 0
        // if indegree is greater than 0, we know that 
        // it is a neighbor for some other character
        
        Deque<Character> q=new  ArrayDeque<>(); 
        StringBuilder sb=new StringBuilder(); 
        for (char c:  graph.keySet()) {
            //if (outdegree[c -'a']==0 && indegree[c-'a']==0) continue; 
            if (indegree[c - 'a']==0) 
                q.offer(c); 
        }
        

        
        while(!q.isEmpty()){
            
            char c=q.poll(); 
            sb.append(c);
            for (char neighbor: graph.get(c)){
                indegree[neighbor -'a']--; 
                if (indegree[neighbor -'a']==0) {
                    q.offer(neighbor); 
                    
                }
                
                
            }
            
        }
        
        System.out.println(sb.toString()); 
        return sb.length() == graph.size() ? sb.toString() : "";
        
        
        
        
    }
}