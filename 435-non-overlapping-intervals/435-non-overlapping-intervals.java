class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        
        //  [[1,2],[1,3], [2,3],[3,4],]
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); 
        
        int[] curr=intervals[0]; 
        int res=0; 
        
        for(int i=1; i < intervals.length; i++){
            
            
            if (intervals[i][0] < curr[1]){
                res++; 
                curr[1]=Math.min(intervals[i][1], curr[1]);
            }
            
            else curr=intervals[i]; 
            
            
        }
        
        return res; 
        
        
        
    }
}