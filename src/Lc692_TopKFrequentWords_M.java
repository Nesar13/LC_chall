import java.util.*;

public class Lc692_TopKFrequentWords_M {


 // we create a freq table in hashmap and
    // insert it into priorityqueue
    // with custom compareTo to lexiographically order from least to greatest
    // we add the min heap into a linkedlist as insertion is O(1) so we
    // effectively reversed this
    //88%
    // O(nlogn)

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> ans= new LinkedList<>();
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word: count.keySet()) {
            heap.offer(word);

            if (heap.size() > k) heap.poll();
        }

        // inserting into the beginning of linkedlist is O(1)
        // ArrayList is slower
        // we reverse the list using the 0th index
        while (!heap.isEmpty()) ans.add(0, heap.poll());

// Collections.reverse(ans)
        return ans;
    }


    public static void main(String[] args) {
        String [] s= {"i", "love", "leetcode", "i", "love"};

        String s1= "hello";
        String s2="cool";


        // compareTo returns positive if the first string is higher lexiographically ("b".compareTo("c") would return negative
        System.out.println(s2.compareTo(s1));
        System.out.println("b".compareTo("c"));

        System.out.println(topKFrequent(s, 5));
    }
}
