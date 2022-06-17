class Solution {
    // 1----2
    //      2----3
    //           3---4
    // 1---------3
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length==0) return 0; 
        int res=0; 
        Arrays.sort(intervals, (a,b) -> a[0]==b[0]? a[1]-b[1] : a[0]- b[0]); 
        int[] temp=intervals[0]; 
        for(int i=1; i < intervals.length; i++){
           // System.out.println(Arrays.toString(temp)); 
            // if start of curr intersect
            if(temp[1] > intervals[i][0]){
                
                res++; 
                temp[1] = Math.min(temp[1], intervals[i][1]); 
            }
            else temp=intervals[i]; 
            
        }
        
        
        return res;
    }
}