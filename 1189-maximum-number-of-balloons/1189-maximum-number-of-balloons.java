class Solution {
    public int maxNumberOfBalloons(String text) {
     if(text.length()==0) return 0; 
        
        HashSet<Character> balloonSet=new HashSet<>();
        HashMap<Character, Integer> map=new HashMap<>(); 
        HashMap<Character, Integer> balloonMap=new HashMap<>(); 
        
        balloonMap.put('b', 1); 
        balloonMap.put('a', 1);
        balloonMap.put('l', 2); 
        balloonMap.put('o', 2);
        balloonMap.put('n', 1); 


        for (char c: text.toCharArray()){
            balloonSet.add(c); 
        }
        
        if(!balloonSet.contains('b') || !balloonSet.contains('a') || 
           !balloonSet.contains('l') || !balloonSet.contains('o') || !balloonSet.contains('n')) return 0; 
       
        for (char c: text.toCharArray()){
            if(balloonMap.containsKey(c)) map.put(c, map.getOrDefault(c, 0) +1 );
            
        }
        
        int res=Integer.MAX_VALUE; 
        
        for (Character c: map.keySet()){
            res=Math.min(res, map.get(c)/balloonMap.get(c)); 
        }
        
       return res;  
    }
}