class Solution {
    public int findLUSlength(String a, String b) {
        
        //    abacd
        // "" 12345
        // c  1233
        // d
        // c
        
        
       if(a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}