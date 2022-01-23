class Solution {
    public int calculateTime(String keyboard, String word) {
        
        HashMap<Character, Integer> map=new HashMap(); 
        
        for (int i=0; i < keyboard.length(); i++){
            
            char c=keyboard.charAt(i); 
            map.put(c, i); 
        }
        
        int res=map.get(word.charAt(0)); 
        for (int i=1; i < word.length(); i++){
            char c=word.charAt(i); 
            char prev=word.charAt(i-1); 
            res += Math.abs(map.get(c) - map.get(prev)); 
        }
        
        return res; 
        
        
    }
}