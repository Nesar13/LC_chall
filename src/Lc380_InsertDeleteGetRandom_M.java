import java.util.*;

public class Lc380_InsertDeleteGetRandom_M {

// use a hashmap to store the value, and index and remove in O(1) TC
    // use an arraylist to pick a random num from list
    // tricky part is to removing
    // 100%
    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;
        Random rnd;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            rnd = new Random();
            list=new ArrayList<>();
        }


        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            // will return the index of the key
            int idx = map.remove(val);
            int last = list.remove(list.size() - 1);
            if(val != last) {

                // list.set will replace the indexed value with the last value that was removed
                // note that index is the index of val in the arraylist
                list.set(idx, last);
                map.put(last, idx);
            }
            return true;
        }
        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rnd.nextInt(list.size()));
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args) {

    }
}
