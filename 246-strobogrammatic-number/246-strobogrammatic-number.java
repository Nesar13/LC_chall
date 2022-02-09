class Solution {
    public boolean isStrobogrammatic(String num) {
        
        HashMap<Character, Character> map=new HashMap(); 
        map.put('0', '0'); 
        map.put('1', '1'); 
        map.put('8', '8'); 
        map.put('6', '9'); 
        map.put('9', '6'); 
        
        
        StringBuilder sb=new StringBuilder(); 
      
        for (int i=num.length()-1; i >=0; i--){
            
            char c= num.charAt(i); 
            
            if(map.containsKey(c)) sb.append(map.get(c)); 
            else return false;  
            
           
            
            
        }
        
        System.out.println(sb.toString());
        
        return sb.toString().equals(num); 
        
    }
}