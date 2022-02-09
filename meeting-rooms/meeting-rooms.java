class Solution {
    
    // 2,4  7,10
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1]- b[1]); 
        
        for (int i=0; i< intervals.length-1; i++){
            
            int[] curr=intervals[i]; 
              System.out.println(Arrays.toString(curr)); 
            if (curr[1] >  intervals[i+1][0]) return false; 
            
            
          
            
            
        }
        
        return true; 
        
    }
}