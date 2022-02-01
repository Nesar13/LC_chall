class Solution {
    public String findContestMatch(int n) {
        List<String> matches = new ArrayList<>();
        for(int i = 1; i <= n; i++) matches.add(""+i);
        
        
        while (matches.size() != 1){
            List<String> temp=new ArrayList(); 
            for (int i=0; i< matches.size()/2; i++){
                
                temp.add("(" + matches.get(i) + ","+ matches.get(matches.size()-i-1) + ")"); 
            }
            
            matches=temp; 
        }
        
        return matches.get(0);
    
    }
}