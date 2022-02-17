class CombinationIterator {
    
    TreeSet<String> set; 
    String[] sortedString;
    int currIndex;

    public CombinationIterator(String characters, int combinationLength) {
        set=new TreeSet(); 
        StringBuilder sb=new StringBuilder(); 
        currIndex=0; 
        createCombination(characters, combinationLength, 0, sb); 
        sortedString=new String[set.size()]; 
        populateString(); 
       
        
    }
    
    void createCombination(String characters, int combinationLength, int start, StringBuilder sb){
        
        if (sb.length()== combinationLength) {
            set.add(sb.toString()); 
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
    
    
    void populateString(){
        System.out.println(set);
        int s=set.size(); 
        for (int i=0; i< s; i++){
            
            sortedString[i]=set.pollFirst(); 
        }
        
    }
    
    public String next() {
        if (currIndex >= sortedString.length ) return "";
        String s=sortedString[currIndex];
        currIndex++; 
        return s; 
    }
    
    public boolean hasNext() {
    
        if(currIndex >= sortedString.length) 
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