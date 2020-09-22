public class Lc190_ReverseBits {
    public static int reverseBits(int n) {

        int res=0;
        for(int i=0;i<32;i++){
            res= ( res << 1 ) | ( n & 1 );
            n = n >> 1;
        }
        return res;
    }
    // you need treat n as an unsigned value
//    public static int reverseBits(int n) {
//
//        String bits=Integer.toBinaryString(n);
//        StringBuilder sb=new StringBuilder();
//        for (int i = 0; i < bits.length(); i++) {
//            sb.append(bits.charAt(bits.length()-1-i));
//        }
//
//        int result=0;
//        for (int i = 0; i <sb.length() ; i++) {
//            if(sb.charAt(i) == '1' ) {
//                result += Math.pow(2, sb.length()-1-i);
//
//                // 964176192 (00111001011110000010100101000000)
//                System.out.println(sb.length());
//                System.out.println(sb.length()-1-i);
//
//            }
//        }
//        return result;
//    }




    public static void main(String[] args) {
        int num= 43261596;

        System.out.println(reverseBits(num));
    }
}
