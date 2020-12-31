import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Lc787_CheapestFlightsWithinKStops_M {



    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<int[], Integer> map=new HashMap<>();


        for (int i = 0; i < flights.length; i++) {

                map.put(flights[i],flights[i][2] );


        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

    pq.addAll(map.keySet());




return -1;
    }

    public static void main(String[] args) {

    }
}
