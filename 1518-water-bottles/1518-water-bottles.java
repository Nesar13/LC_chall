class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int res=numBottles; 
        
        if(numExchange > numBottles || numBottles==0) return res; 
        
        while(numBottles >= numExchange){
            
            int remain=numBottles % numExchange; 
            int getFullBottles=numBottles/numExchange; 
            
            res +=getFullBottles; 
            
            numBottles= remain+ getFullBottles; // number of empty bottles
        }
        
        return res; 
        
    }
}