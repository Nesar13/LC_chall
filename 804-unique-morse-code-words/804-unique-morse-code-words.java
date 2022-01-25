class Solution {
    public int uniqueMorseRepresentations(String[] words) {
            String[] MORSE = new String[]{
                        ".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.." };
        
        
        HashSet<String> set=new HashSet<>(); 
        int res=0; 
        StringBuilder sb=new StringBuilder(); 
        for (String w: words){
            sb.setLength(0); 
            for (int i=0; i < w.length(); i++){
                sb.append(MORSE[w.charAt(i)-'a']); 
                
            }
            // if (!set.contains(sb.toString())) 
            //     res++;
            set.add(sb.toString());
        }
        
        
        return set.size(); 
    }
}