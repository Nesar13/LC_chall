public class Lc1160_FindMatchingWord {


    public static int countCharacters(String[] words, String chars) {
        int sumcount =0;
        int [] a= new int[26];
        //count of original
        for (int i = 0; i < chars.length(); i++) {
            a[chars.charAt(i)-'a']++;
        }
        for (String word : words) {// loop through each word
            //create copy to compare chars for each word in array
            int [] temp= a.clone();
            //loop through each char in words
            for (int j = 0; j <word.length() ; j++) {
                //derement if letter exist
                if (temp[word.charAt(j)-'a']>=0)
                    temp[word.charAt(j)-'a']--;
                //if word does not exist go to next word
                if (temp[word.charAt(j)-'a']<0){
                    break;
                }
                //if whole word exist then add it to sum
                if (j==word.length()-1){
                    sumcount+=word.length();
                }
            }
        }
        return sumcount;

    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(countCharacters(words, chars));

    }

}
