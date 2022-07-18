class Solution {
    public int maxProfit(int[] prices) {
        
        HashMap<String, Integer> memo=new HashMap<>(); 
        return dfs(prices, memo, 0, true); 
        
        
    }
    
    
    int dfs(int[] prices, HashMap<String, Integer>  memo, int index, boolean buying){
        
        if(index >= prices.length) return 0;
        
        String key=buying + "=>" + index; 
        
        if(memo.containsKey(key)) return memo.get(key); 
        
        int cooldown=dfs(prices, memo, index+1,buying );
            int buyOrSell=Integer.MIN_VALUE; 
            
            if(buying){
                // notice that we subtract prices if buying
                buyOrSell=dfs(prices, memo, index+1, !buying) - prices[index]; 
            }
            else { // we have to sell and skip the next index because of cooldown
                buyOrSell=dfs(prices, memo, index+2, !buying) + prices[index]; 
            }
        
        memo.put(key, Math.max(buyOrSell, cooldown)); 
        
        return memo.get(key); 
        
        
        
        
    }
}