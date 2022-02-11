class Solution {
    public int numTilePossibilities(String tiles) {
        
        HashSet<String> set=new HashSet(); 
        StringBuilder sb=new StringBuilder(); 
        boolean[] visited=new boolean[tiles.length()]; 
        dfs(tiles, set, sb, visited); 
        
        return set.size(); 
        
        
    }
    
    
    public void dfs (String tiles, Set<String> set, StringBuilder sb, boolean[] visited){
        
          if (sb.length() > 0){
            set.add(sb.toString()); 
        }
        if (sb.length() >= tiles.length()) return;
      
        
        for (int i=0; i < tiles.length(); i++){
            if (visited[i]) continue; 
            visited[i]=true; 
            int len=sb.length(); 
            sb.append(tiles.charAt(i)); 
            
            dfs(tiles, set, sb, visited); 
            
            sb.setLength(len); 
            visited[i]= false; 
            
            
        }
        
    }
}