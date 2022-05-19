class Solution {
    
    // 1) we have to realize that we can do this in O(n*q) but it will 
    // result in a TLE
    // 2) we can do better by using a min heap
    // 3) We should create an auxiliary array to store the queries and its' 
    // corresponding index since we have to sort this
    // 4) we can create the min heap by sorting by the range (right-left)
    // and insert the interval
    //5) we then insert into our pq the interval that meets the criteria: 
    // if start is < than currQuery. We will remove this if end time is less that current
    // query in another while loop
    // O(nlogn + qlog(q)) time since the for loop we iterate at most 2n 
    // so the for loops is O(2n + q)
    // O(q) space where q is the length of our query
    public int[] minInterval(int[][] intervals, int[] queries) {
        // create tuple of queries and index so we will have access to original 
        // index 
        int[][] queriesIndex=new int[queries.length][2]; 
        for (int i=0; i < queries.length; i++){
            queriesIndex[i][0]=queries[i]; 
            queriesIndex[i][1]=i; 
            
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0])); 
        Arrays.sort(queriesIndex, (a,b)-> Integer.compare(a[0], b[0])); 
        //note that we are sorting by the range in pq
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[1]-a[0] , b[1]-b[0])); 
        int[] res=new int[queries.length]; 
        
        int k=0; 
        for (int i=0; i< queriesIndex.length; i++){// this is O(n+q) since we traverse the intervals at most twice
            
            int currQuery=queriesIndex[i][0]; 
            int resIndex=queriesIndex[i][1]; 
            
            // we will add to our pq if we find that there is a candidate that we can fit
            // the current query in the range, so we will add intervals with start time lower than 
            // current query
            // note that we don't reset j since we are adding all potential ranges 
            // for this current query
            while ( k < intervals.length && intervals[k][0] <= currQuery ) pq.offer(intervals[k++]); 
            
            // if the end time is less than currentQuery, then this interval
            // will not be a solution for this query or future queries
            while ( !pq.isEmpty() && pq.peek()[1] < currQuery) pq.poll();
            
            // we will add to the current index of our query the solution
            // for the range (right-left+1)
            res[resIndex]=pq.isEmpty() ? -1 : pq.peek()[1]- pq.peek()[0] +1 ; 
            
        }
        
        
        return res; 
        
        
        
        
    }
}