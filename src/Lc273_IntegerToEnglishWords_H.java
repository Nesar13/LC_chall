public class Lc273_IntegerToEnglishWords_H {

    private static final String[] LESSTHAN20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
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
    }

    public static void main(String[] args) {

        System.out.println(numberToWords(12345));

    }
}
