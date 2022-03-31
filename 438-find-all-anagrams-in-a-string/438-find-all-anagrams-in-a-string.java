class Solution {
   public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length()==0 || s==null) //base case if no string is given
            return result;
//add count of each letters in p(words we are looking for)
        int[] char_counts= new int[26];
        for (int i = 0; i < p.length(); i++) {
          char_counts[p.charAt(i)-'a']++;
        }
//Sliding Window
        //Boundry
        int left=0;//begining expanding boundry of window
        int right=0;//ending expanding boundry
while (right<s.length()) {//while right bound has not reach end of string
            if (char_counts[s.charAt(right)-'a']>0) {
                //if matching char exist then remove it in char_count
                char_counts[s.charAt(right)-'a']--;
                //expand the window right side
                right++;
            }else {
                //if char is not >0 then increment it in char_count
                //that means next iteration right will catch it in if statement
                char_counts[s.charAt(left)-'a']++;
                //expand left window (shrink it)
                left++;
            }
            if (right-left==p.length()) {//as long as the array length bound stay fixed
                //add the item
                result.add(left);
            }
}
return result;
    }

}