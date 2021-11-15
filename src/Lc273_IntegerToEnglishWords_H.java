public class Lc273_IntegerToEnglishWords_H {

/*    private static final String[] LESSTHAN20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", " Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String SPACE = " ";

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private static String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20) {
            sb.append(LESSTHAN20[num]);
        } else if (num < 100) {
            sb.append(TENS[num / 10]);
            if (num % 10 != 0) {
                sb.append(SPACE).append(helper(num % 10));
            }
        } else if (num < 1000) {
            sb.append(helper(num / 100)).append(" Hundred");
            if (num % 100 != 0) {
                sb.append(SPACE).append(helper(num % 100));
            }
        } else if (num < 1_000_000) {
            sb.append(helper(num / 1000)).append(" Thousand");
            if (num % 1000 != 0) {
                sb.append(SPACE).append(helper(num % 1000));
            }
        } else if (num < 1_000_000_000) {
            sb.append(helper(num / 1_000_000)).append(" Million");
            if (num % 1_000_000 != 0) {
                sb.append(SPACE).append(helper(num % 1_000_000));
            }
        } else {
            sb.append(helper(num / 1_000_000_000)).append(" Billion");
            if (num % 1_000_000_000 != 0) {
                sb.append(SPACE).append(helper(num % 1_000_000_000));
            }
        }

        return sb.toString();
    }*/
    private static  final String[]LESS_THAN_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static final String[]TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private static final String[]THOUSANDS = {"","Thousand","Million","Billion"};

    // we build up our words from the end using recursion
    // example: 12345, we would recursively generate three hundred forty five first
    // then we increment the thousands and divide by 1000 to generate the next
    // numbers
    public static String numberToWords(int num) {
        if(num ==0)return "Zero";

        int i =0;
        String words ="";

        while(num >0) {
            if(num %1000!=0){
                int n=num % 1000;
                words =helper(num %1000) + THOUSANDS[i] +" "+words; }
            num /=1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if(num ==0)
            return "";
        else if(num <20)
            return LESS_THAN_20[num] +" ";
        else if(num <100)
            return TENS[num /10] +" "+helper(num %10);
        else
            return LESS_THAN_20[num /100] +" Hundred "+helper(num %100);
    }

    public static void main(String[] args) {

        System.out.println(numberToWords(1234567));

    }
}
