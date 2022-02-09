class Solution {
    // The trick is traversing the graph in reverse order. 
    //Like that "bac" -> "bc" -> "b". It is easier to calculate next candidate children in reverse order.
    //For example from "b" -> ... you should try all alphabet letters but in reverse order you can only remove one letter "bc" -> "b" or "bc" -> "c".      //Time Complexity = O(NxL), N is the words count, L is the length of words. 
    //Space Complexity = O(NxL) for storing set of words and score are    same. (Recursive stack can be O(N) space at most.)
       private int backtrack(HashSet<String> set, HashMap<String, Integer> map, String str) {
        //Integer pathLen = map.get(str);
         if (map.containsKey(str)) return map.get(str); 
        int res = 1;
        String sb = null;
        for(int i=0; i<str.length(); i++) {
            sb = str.substring(0, i) + str.substring(i+1, str.length());
            if(set.contains(sb)) {
                res = Math.max(1+backtrack(set, map, sb), res);
            }
        }
        map.put(str, res);
        return res;
    }
    
    public int longestStrChain(String[] words) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            set.add(word);
        }
        int ans = 1;
        for(String word: words){
            ans = Math.max(ans, backtrack(set, map, word));
        }
        return ans;
    }
    
     
}