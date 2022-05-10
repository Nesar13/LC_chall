class Solution {
    // 2, abc
    // 3, def
    
     HashMap<Character, String> map=new HashMap<>(); 
    
    public List<String> letterCombinations(String digits) {
   
        List<String> res=new ArrayList<>(); 
        if(digits.length()==0) return res; 
        map.put('2', "abc"); 
        map.put('3', "def"); 
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs"); 
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtrack(digits, 0,new StringBuilder(), res );
        
        return res; 
        
    }
    
    void backtrack(String digits, int curr, StringBuilder sb, List<String>res  ){
        
        if (sb.length()==digits.length()){
            res.add(sb.toString());
            return; 
        }
        
        String nextLetters=map.get(digits.charAt(curr));
        //if(nextLetters==null) return; 
        for (int i=0; i < nextLetters.length(); i++){
            int prevLength=sb.length(); 
            sb.append(nextLetters.charAt(i)); 
            backtrack(digits, curr+1, sb, res);
            sb.setLength(prevLength); 
        }
        
    }
}