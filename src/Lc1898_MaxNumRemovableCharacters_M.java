public class Lc1898_MaxNumRemovableCharacters_M {

    public static int maximumRemovals(String s, String p, int[] removable) {

        StringBuilder sb=new StringBuilder();
        int res=0;
        int plen=p.length();

        for(char c: s.toCharArray()) sb.append(c);

        for (int i =0; i< removable.length; i++) {

            sb.deleteCharAt(removable[i]);
            String s1=sb.toString();

            int slen=sb.length();
            int pe=0;
            int subs=0;

            // check if still subsequence

            for (int j=0; j < slen; j++) {



                if(pe < plen && sb.charAt(j)==p.charAt(pe)) {

                    pe++;
                    subs++;
                }

                if(subs==plen) {
                    res++;
                    break; }

                if(j==slen-1 && subs != plen) return res;



                System.out.format("plen: %d, pe: %d, j: %d, , i: %d subs: %d slen: %d , res: %d \n", plen, pe, j, i, subs, slen,  res);

            }
        }
        return res;


    }

    public static void main(String[] args) {
        String s = "abcacb", p = "ab";
        int [] removable = {3,1,0};

        String s1 = "qobftgcueho";
        String s2="obue";
        int [] arr={5,3,0,6,4,9,10,7,2,8};

        //Input: s = "abcab", p = "abc", removable = [0,1,2,3,4]
        //Output: 0
        //Explanation: If you remove the first index in the array removable, "abc" is no longer a subsequence.

        System.out.println(maximumRemovals(s1, s2, arr));
    }


}
