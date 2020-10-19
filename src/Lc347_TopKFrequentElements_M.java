import java.util.*;

public class Lc347_TopKFrequentElements_M {
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }


       // Note that it is a min heap
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get)); // equivalent to (a, b) -> map.get(a) - map.get(b)

        // O(N log k) < O(N log N) time
        // building a heap with k size since it is a min heap
        // we are removing the less frequent keys
        for(int key : map.keySet()){ heap.add(key);
            if (heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i]=heap.poll();
        }

        return ans;
    }
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> map = new HashMap();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(map::get));  // equivalent to (n1, n2) -> map.get(n1) - map.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        // building a heap with k size since it is a min heap
        // we are removing the less frequent keys
        for (int n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }



}
