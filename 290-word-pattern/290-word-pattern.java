class Solution {
    public boolean wordPattern(String pattern, String s) {
        
   
        String[] arr=s.split(" ");
        if (arr.length != pattern.length()) return false; 
        
        HashMap<Character, String> map=new HashMap<>(); 
        
        HashSet<Character> set=new HashSet<>();
        HashSet<String> sSet=new HashSet<>(); 
        
        for (int i=0; i < pattern.length(); i++){
            char c=pattern.charAt(i); 
            
            if ( !set.contains(c) && !sSet.contains(arr[i])) map.put(c, arr[i]); 
            set.add(c); 
            sSet.add(arr[i]);
            
        }
        
        for (int i=0; i < arr.length; i++){
            
            String curr=arr[i];
            
            char p=pattern.charAt(i); 
            if(map.get(p) == null || !curr.equals(map.get(p))) return false;

        }
        
        return true; 
        
        
    }
}