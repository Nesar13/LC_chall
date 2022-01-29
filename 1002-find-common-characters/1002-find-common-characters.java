class Solution {
    // 1) I intially thought we can just store frequency
    // and if the char was greater or equal to number of words
    // we can just add to our result
    // 2) This assumption is incorrect since we can have 
    // many of the same chars in one word
    // so we have to get the min frequency of each char in each word
    public List<String> commonChars(String[] words) {
        int[] freq=new int[26]; 
        Arrays.fill(freq, Integer.MAX_VALUE); 
        for (String s: words){
            int[] temp=new int[26]; 
            for (int i=0; i < s.length(); i++){
                char c=s.charAt(i); 
                temp[c-'a']++; 
                
            }
            
            for (int i=0; i < 26; i++){
                freq[i]=Math.min(temp[i], freq[i]); 
            }
        }
        
        List<String> res=new ArrayList(); 
        // we know that the min value has to be at least 1 or greater
        // since we got the min frequency of chars of all the strings 
        for (int i=0; i< 26; i++){
            
            int curr=freq[i]; 
            while(curr-- >0) res.add(""+(char)('a' + i)); 
                
            }
            
        
        
        
        return res; 
        
        
    }
}