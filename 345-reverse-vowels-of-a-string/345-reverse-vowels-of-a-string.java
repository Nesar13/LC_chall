class Solution {
    public String reverseVowels(String s) {
        
        HashSet<Character> set=new HashSet(); 
        set.add('a'); 
        set.add('i'); 
        set.add('o'); 
        set.add('e'); 
        set.add('u'); 
        
        int left=0; 
        int right= s.length()-1; 
        
        char[] c=s.toCharArray(); 
        
        while (left < right){
            
            char l=c[left]; 
            
            char lc=Character.toLowerCase(l); 
            
            char r=c[right]; 
            
            char rc=Character.toLowerCase(r); 
            
            if (!set.contains(lc)) left++; 
            if(!set.contains(rc)) right--; 
            
            if(set.contains(lc) && set.contains(rc)) {
                
                //swap function and increment and decrement
                swap(c, left, right); 
                left++; 
                right--; 
            }
            
            
            
            
        }
        
        
        return String.valueOf(c); 
        
        
        
    }
    
    
    void swap(char[] c, int left, int right){
        char temp=c[left]; 
        c[left]=c[right]; 
        c[right]=temp; 
        
        
    }
    
    
    
}