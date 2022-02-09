class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while( index1 >=0 || index2 >=0 || carry >0){
            int n1 = 0;
            int n2 = 0;
            if(index1 >=0){
                n1 = num1.charAt(index1) - '0';
                index1--;
            }
            if(index2 >= 0){
                n2 = num2.charAt(index2) - '0';
                index2--;
            }
            int sum = (n1 + n2 + carry) %10;
            carry = (n1 + n2 + carry)/10;
            sb.append(sum);
        }
        return sb.reverse().toString();
        
    }
}