class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] c1=s1.split("\\s+"); 
        String[] c2=s2.split("\\s+"); 
        
        
        Map <String, Integer>  map=new HashMap<>(); 
        
        for (String s: c1){
            map.put(s, map.getOrDefault(s, 0)+1); 
            
        }
        
        for (String s: c2){
            map.put(s, map.getOrDefault(s, 0)+1); 
            
        }
        
    List<String> temp=new ArrayList(); 
        
        for (String s: map.keySet()){
            if (map.get(s)==1) temp.add(s); 
            
        }
        
        String[] res=new String[temp.size()]; 
        
        temp.toArray(res); 
        
        return res; 
        
    }
}