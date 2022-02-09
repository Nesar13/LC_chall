class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0]; 
        
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); 
        
        for (int i=0; i < stones.length; i++){
            
            pq.offer(stones[i]); 
    
        }
      
        while(!pq.isEmpty()){
            if (pq.size()==1)return pq.peek(); 
            int y= pq.poll(); 
            int x=pq.poll(); 
            
            if(x != y) {
                y=y-x;
                pq.offer(y); 
            }
            
        }
        
        return 0; 
    }
}