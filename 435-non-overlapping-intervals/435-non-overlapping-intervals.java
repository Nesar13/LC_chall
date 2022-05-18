class Solution {
    
    // We can sort the array, and keep like a running previous interval
    // We have to realize that if there is an overlap, 
    // we should keep the min end time, so we don't really need to store the previous
    // interval, just the end time
    public int eraseOverlapIntervals(int[][] intervals) {
        
        
        //  [[1,2],[1,3], [2,3],[3,4],]
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); 
        
        int end=intervals[0][1]; 
        int res=0; 
        
        for(int i=1; i < intervals.length; i++){
            
            
            if (intervals[i][0] < end){
                res++; 
                end=Math.min(intervals[i][1], end);
            }
            
            else end=intervals[i][1]; 
            
            
        }
        
        return res; 
 
    }
}