// we have to realize that when we have to store a 
// running max and min, and if values are being updated
// we have to use a tree structure like treemap or heaps

class StockPrice {
    
    // record to store <time, price> 
    TreeMap<Integer, Integer> record = new TreeMap<>();
    // vals to store <price, <set: time>>
    TreeMap<Integer, Set<Integer>> vals = new TreeMap<>();

    public void update(int timestamp, int price) {
        
        if (record.containsKey(timestamp)){
            
            int prevPrice=record.get(timestamp); 
            
            Set<Integer> set=vals.get(prevPrice); 
            
            // we want to remove the timestamp association of that value
            // since the value associated with the time will be updated
            set.remove(timestamp); 
            if (set.isEmpty()){
                vals.remove(prevPrice); 
            }
 
        }
        
        vals.putIfAbsent(price, new HashSet<>()); 
        vals.get(price).add(timestamp); 
        record.put(timestamp, price); 
        
        
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}