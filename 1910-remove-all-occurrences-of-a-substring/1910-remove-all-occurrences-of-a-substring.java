class Solution {
    //"hijzgaovndkjiiuwjtcpdpbkrfsi"
    //     public String removeOccurrences(String s, String part) {
    //     StringBuilder sb=new StringBuilder(s); 
    //     int plen=part.length();
    //     while(true)
    //     {
    //         int index=s.indexOf(part);
    //         if(index==-1) return s;
    //         s=s.substring(0,index)+s.substring(index+plen);
    //     }
    // }
        public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int pre = 0;
        int i = sb.indexOf(part, pre);
        while (i >= 0) {
            sb.replace(i, i + part.length(), "");
          
            // given like ababcc and part=abc
            // we would get abc after first erasure, so we want to start two indexes less because we 
            // wwant to take into consideration the the character after being erased
           pre = Math.max(0, i - part.length() + 1);
            i = sb.indexOf(part, pre);
        }
        return sb.toString();
    }
}