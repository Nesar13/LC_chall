import java.util.*;

public class LamdaExpressions {

    //static void insertAndPrint(AbstractMap<Integer, String> map)
    static void insertAndPrint(TreeMap<Integer, String> map)
    {
        int[] array= {1, -1, 0, 2,-2};
        for (int x: array)
        {
            map.put(x, Integer.toString(x));
        }
        for (int k: map.keySet())
        {
            System.out.print(k + ", ");
        }
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y) -> y-x);
            List<Integer> list=new ArrayList<>();
            list.add(1);
            list.add(7);
            list.add(2);
            list.add(1);

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        insertAndPrint(map);




    }
}
