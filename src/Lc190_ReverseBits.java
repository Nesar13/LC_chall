public class Lc190_ReverseBits {
    public static int reverseBits(int n) {

        int res=0;
        for(int i=0;i<32;i++){
            res= ( res << 1 ) | ( n & 1 );
            System.out.println("res<<1 "+ Integer.toBinaryString( res << 1 ) +" integer: "+(res << 1));
            System.out.println("res "+ Integer.toBinaryString( res)+ " integer: "+res) ;

            System.out.println("n: "+ Integer.toBinaryString( n) + " integer: "+n);
            System.out.println("n &1: "+ Integer.toBinaryString( n & 1 )+ " integer: "+(n & 1 ));
            n = n >> 1;
            System.out.println("n "+ Integer.toBinaryString( n)+ " integer: "+n) ;
            System.out.println("--------------------------------------------------------------------------");
        }
        return res;
    }
    // you need treat n as an unsigned value
    // my solution
    public static int reverseBits2(int n) {

        String bits=Integer.toBinaryString(n);
        System.out.println(bits);

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < bits.length(); i++) {
            sb.append(bits.charAt(bits.length()-1-i));
        }
        if (bits.length() != 32) {
        for (int i = 0; i <32-bits.length() ; i++) {
            sb.insert(bits.length(), "0");
        }
        }
        System.out.println(sb.length());

        int result=0;
        for (int i = 0; i <32 ; i++) {
            if(sb.charAt(i) == '1' ) {
                result += Math.pow(2, sb.length()-1-i);

                // 964176192 (00111001011110000010100101000000)
                System.out.println(sb.length());
                System.out.println(sb.length()-1-i);

            }
        }
        return result;
    }




    public static void main(String[] args) {
        int num= 12; // 805306368

        System.out.println(reverseBits(num));
    }
}
