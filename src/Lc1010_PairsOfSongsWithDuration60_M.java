public class Lc1010_PairsOfSongsWithDuration60_M {
    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            someFunction();
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
public static void someFunction() {

    System.out.println("Hi we're in a new function");
}
    public static void main(String[] args) {
Lc66_PlusOne newClass=new Lc66_PlusOne();
int [] arr= {3,5,6 };
newClass.plusOne1(arr);

//int [] arr={30,20,150,100,40};

        System.out.println(numPairsDivisibleBy60(arr));
    }
}
