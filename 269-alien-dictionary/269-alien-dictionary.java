class Solution {
    // words = ["wrt","wrf","er","ett","rftt"]
    // t -> f
    // w -> e
    // r -> t
    // Map <Character, Set>: [t : f], [w: e],..
    // where the key is the parent, and the children are in the set
    
    // keep track of indegree
    //   -this is how we will traverse level by level 
    //   when indegree of a chracter is 0
    // 
    //   -we can have a cycle 
    //create a graph
    //  -use bfs to traverse graph
 

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
            
            // for cases like "abc, ab" we return empty
            if (first.length() >second.length() && first.startsWith(second)) {
            return "";
        }
            
            int n=Math.min(first.length(), second.length()); 
            
            for (int j=0; j < n; j++){
                
                char parent=first.charAt(j); 
                char child=second.charAt(j); 
                if (parent == child) continue; 
                
                // note that we don't want increment indegree unless
                // it is new edge
                if(!graph.get(parent).contains(child)){
                graph.get(parent).add(child); 
                indegree[child-'a']++;
                }
                
                // since we dont care after the first comparison
                // e.g. "abcf, abde" where we know ab are similar
                // but as soon as we see c comes before d, we can note that 
                // in graph, and the rest are not relevant
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
            }}
        
        return sb.length() == graph.size() ? sb.toString() : "";

    }
}