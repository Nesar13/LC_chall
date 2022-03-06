

class Solution {
    public int getKth(int lo, int hi, int k) {
        
        Map<Integer, Integer> cache=new HashMap();  
     
        // we have to consider cases where the values(power) is the same, so we return 
        // the max index if so
        // note we need <> for priorityqueue
        Queue<Data> pq=new PriorityQueue<>( (a, b) -> a.val==b.val? b.index-a.index : b.val - a.val ); 
        for (int i=lo; i <= hi; i++){
            
           
            int val=getPower(i, cache); 
            Data d=new Data(i, val); 
            pq.offer(d); 
            if (pq.size() > k) pq.poll(); 
        }
        
        return pq.poll().index; 
        
    }
    
    int getPower(int num, Map<Integer, Integer> cache) {
        if (cache.containsKey(num)) return cache.get(num); 
        if (num==1) return 0; 
        
        int count= 1 + (num % 2==0 ? getPower(num/2, cache) : getPower(3*num+1, cache)); // adding 1 
        
        cache.put(num, count); 
        
        return count; 
        
    }
    

}

     class Data{
        
        public int index; 
        public int val; 
        
        Data(int index, int val)
        {
            this.index=index; 
            this.val=val; 
        }
    }