import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Lc146_LRUcache_M {

    static HashMap<Integer, Integer> map=new HashMap<>();
    static Queue <Integer> queue=new LinkedList<>();
    static int maxCapacity=0;

    public static void LRUCache(int capacity) {
        maxCapacity=capacity;


    }

    public static int get(int key) {
        int val=map.getOrDefault(key, -1);
        if (val != -1 ) {

            leastUsed(key);
        }
        return val;


    }

    public static void put(int key, int value) {
        map.put(key,value);
        leastUsed(key);
    }

    public static void leastUsed(int key) {

        queue.add(key);

        if (queue.size()-1==maxCapacity && map.size()==queue.size()-1){

        map.remove(queue.poll());
        }


    }



    public static void main(String[] args) {
        LRUCache(2);
       put(2, 1); // cache is {1=1}
        System.out.println("queue: "+ queue);
        put(1, 1); // cache is {1=1, 2=2}
        System.out.println("queue: "+ queue);
        System.out.println("map: "+ map);
        System.out.println(get(2));
        System.out.println("queue: "+ queue);
        System.out.println("map: "+ map);// return 1
        put(4, 1); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("queue: "+ queue);
        System.out.println(get(1));
        System.out.println("queue: "+ queue);
        System.out.println("map: "+ map);
        System.out.println(get(2));
    }
}
;