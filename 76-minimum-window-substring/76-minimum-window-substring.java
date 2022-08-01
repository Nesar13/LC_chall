class Solution {
    
    // 1)We can do this with a window sliding algo
    // 2)we can have two maps: one to store characters for s and one for t
    // 3) we can have a variable to keep track of all the relevant characters
    // we found in s and once this variable has the size of t
    // we can update our minimun length and our starting index for the substring
    // 4) We need a while loop since we may encounter letters that occur in s more than
    // it occurs in t, so we can reduce window size
    // TC: O(n) | SC: O(n)
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t=="") return ""; 
        
        // since we will have lowercase and uppercase 
        HashMap<Character, Integer> tmap=new HashMap<>();
        HashMap<Character, Integer> smap=new HashMap<>(); 
        
        for (char c: t.toCharArray()) tmap.put(c, tmap.getOrDefault(c, 0) + 1); 
        
        int matched=0; // the num of char we have matched in s
        int left=0; 
        int minLen=s.length() +1; // length of our window
        int subStrStart=0; // starting index of window
        
        for (int right=0; right < s.length(); right++){
            
            char r=s.charAt(right);
            if(tmap.containsKey(r)) { 
                smap.put(r, smap.getOrDefault(r, 0) +1);
                // count only if freq is less than char in t
                // example: s="aacd" t="ad"
                // we don't want to increment matched twice since 
                // we encounter two As
                if(smap.get(r) <= tmap.get(r)) matched++; 
            }
            
            // a while statement since we can have a similar 
            // example as above
            //// example: s="aaacde" t="ad"
            // we can have characters in s that appear more than
            // in t, so we can reduce the window to acd instead of aaacd
            while(matched==t.length()) {
                if(minLen > right-left +1){
                    minLen=right-left+1; 
                    subStrStart=left; 
                }
                char delete=s.charAt(left); 
                left++; 
                if(smap.containsKey(delete)){
                    if(smap.get(delete) <= tmap.get(delete)) matched--; 
                    smap.put(delete, smap.get(delete)-1); 
                }
            }

        }
        
        return minLen > s.length() ? "" : s.substring(subStrStart, subStrStart+minLen); 
        
        
        
        
    }
}