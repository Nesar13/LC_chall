import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Lc451_SortsCharactersFrequency_M {
    public static String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(map::get)));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            for (int j = 0; j < map.get(pq.peek()) ; j++) {
                sb.append(pq.peek());
            }
            pq.poll();
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
