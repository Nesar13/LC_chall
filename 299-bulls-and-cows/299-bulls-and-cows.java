class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls=0; 
        int cows=0; 
        HashMap<Character, Integer> map=new HashMap<>(); 
        for (int i=0; i < secret.length(); i++){
            
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0)+1); 
        }
        
        int len=Math.min(secret.length(), guess.length()); 
        
        for (int i=0; i < len; i++){
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
             map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0)-1);    
            }
            
        }
        
        for (int i=0; i < len; i++){
            
            char c=guess.charAt(i); 
            char s=secret.charAt(i); 
            if(c==s) continue;
            if (map.containsKey(c)){
                
                if(map.get(c) > 0) {
                    map.put(c, map.getOrDefault(c, 0) - 1); 
                    cows++; 
                }
            }
        }
        
        StringBuilder sb=new StringBuilder(); 
        sb.append(bulls).append("A").append(cows).append("B");
        
        return sb.toString(); 

        
        
        
        
    }
}