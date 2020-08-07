import java.util.Arrays;

public class Lc122_BestTimetoBuyandSellStocks {


    public static int maxProfit(int[] prices) {
        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++) {
            //check to see if current index price is greater than previous
            //if so add to maxprofit
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    public static void main(String[] args) {

        int[] arr={1, 7, 2, 3, 6, 7, 6, 7};

        System.out.println(maxProfit(arr));
    }
}
