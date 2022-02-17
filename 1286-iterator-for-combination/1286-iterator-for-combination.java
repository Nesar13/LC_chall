class CombinationIterator {
    
   List<String> res; 
   
    int currIndex;

    public CombinationIterator(String characters, int combinationLength) {
        res=new ArrayList<>();  
        StringBuilder sb=new StringBuilder(); 
        currIndex=0; 
        createCombination(characters, combinationLength, 0, sb); 
      
       
        
    }
    
    void createCombination(String characters, int combinationLength, int start, StringBuilder sb){
        
        if (sb.length()== combinationLength) {
            res.add(sb.toString()); 
            return; 
          
        }
        if(sb.length() > combinationLength) return;
        for (int i=start; i < characters.length(); i++){
            int len=sb.length();
            sb.append(characters.charAt(i)); 
            createCombination(characters, combinationLength, i+1, sb);
            sb.setLength(len);
        }
        
    }
    
    
    
    public String next() {
        if (currIndex >=res.size() ) return ""; 
        return res.get(currIndex++);
    }
    
    public boolean hasNext() {
    
        if(currIndex >= res.size()) 
            return false; 
        
        return true; 
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */