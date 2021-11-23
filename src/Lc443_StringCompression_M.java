public class Lc443_StringCompression_M {

// we basically iterate through the char array
    //we count the number of repetions of a char and
    // it to our char array after the character
    // note that we have to account for when frequency is greater than 10
    // O(n) time | O (1) space
    public static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            // iterating through the same char
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                // since we can have a frequency of a character be more than
                // 10, we can convert  the count to a string and get the char array
                // that we
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }

    public static void main(String[] args) {
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

        char[] chars=new char[] {'a','a','b','b','c','c','c'};

        System.out.println(compress(chars));

    }
}
