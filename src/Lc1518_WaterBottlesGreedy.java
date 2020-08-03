public class Lc1518_WaterBottlesGreedy {

    public  static int numWaterBottles(int numBottles, int numExchange) {


        int count=numBottles;
        if(numExchange > numBottles || numBottles == 0)
            return count;

        while(numBottles >= numExchange) { // While bottles can be exchanged

            int remain = numBottles%numExchange; // Remaining empty bottles (Remainder)

            int getFull = numBottles/numExchange; // Number of full bottles received

            count += getFull; // Add in count

            numBottles = remain + getFull; // Update the available empty bottles

        }

        return count;
    }
    public static void main(String[] args) {

        System.out.println(numWaterBottles(9, 3));
    }

}