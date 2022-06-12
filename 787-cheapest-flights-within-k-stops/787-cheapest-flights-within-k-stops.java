class Solution {
    
    // 1)  We can use bellman ford since we wanted k stops
    // 2) we use an array cost to keep track of the min cost to reach
    // and a temp array to keep track of k layers 
    // 3) we need this temp array since the algorithm is made to traverse all nodes 
    // so returning the destination will yield an incorrect result
    //example: 
    //[[0,1,100],[1,2,100],[0,2,500]], k=1
    // cost: 0  1   2       k=0
    //       0  inf inf 
    // temp: 0  1   2
    //       0  100 500
    
    // copy temp to cost:   k=1
    //cost: 0   1   2
    //      0   100 500
    
    // temp:0   1   2
    //      0   100 200 --copy to cost and we will return 200 for destination 2
    
      public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE); 
        cost[src]=0; // We set src to zero so we can traverse from there level by level
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE) // key to traverse level by level
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}