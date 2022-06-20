class Solution {
    
    // 
     public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int elem: hand) minHeap.add(elem);

        
         while(!minHeap.isEmpty()){
             
             int headNode=minHeap.poll(); 
             for (int i=1; i < W ; i++){ // we are including headNode as part of group size, so i < W not i <= W
                 
                 if (!minHeap.remove(headNode+i)) return false; 
             }
             
         }
         
         return true; 
         
    }
}