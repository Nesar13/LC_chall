class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> wordDict=new HashSet<String>(); 
        HashSet<String> visited=new HashSet<>(); 
        
        for (String s: wordList) wordDict.add(s); 
        
        
        ArrayDeque<String> q=new ArrayDeque<>(); 
        
        q.offer(beginWord); 
        visited.add(beginWord); 
        int count=1; 
        while(!q.isEmpty()){
            
            int n=q.size(); 
            
            for (int j=0; j  < n ; j++){
                
                
            
            String curr=q.poll(); 
            if(curr.equals(endWord)) return count; 
            
            char[] currArr=curr.toCharArray(); 
            
            for (int i=0; i < curr.length(); i++){
                char tmp=currArr[i]; 
                for (char c='a'; c<= 'z'; c++){
                    
                    currArr[i]=c; 
                    String s=String.valueOf(currArr); 
                    if (wordDict.contains(s) && !visited.contains(s)){
                        q.offer(s); 
                        visited.add(s); 
                    }
                    
                }
                currArr[i]=tmp; 
            }
            }
            
            count++; 
            
            
            
            
        }
        
        
        
        return 0; 
    }
}