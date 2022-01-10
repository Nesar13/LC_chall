class Solution {
    //"hijzgaovndkjiiuwjtcpdpbkrfsi"
        public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s); 
        int plen=part.length();
        while(true)
        {
            int index=s.indexOf(part);
            if(index==-1) return s;
            s=s.substring(0,index)+s.substring(index+plen);
        }
    }
}