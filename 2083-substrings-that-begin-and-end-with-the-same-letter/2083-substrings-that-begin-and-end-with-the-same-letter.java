class Solution {
    //  5= aaaaa
    // x 4=11 axxaxxaxxa
    // a 3=4   a xxa xxa
    // b 2 =3
    //   1=1
    
  public long numberOfSubstrings(String s) {
        long[] freq = new long[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        
        long result = 0;
        for(long count: freq){
            result += count*(count-1)/2+count;
        }
        
        return result;
    }
}