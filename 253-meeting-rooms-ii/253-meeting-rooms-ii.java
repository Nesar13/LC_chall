class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); 
        
        
        // 1    2   3   8   10  11
        // 7    10  12  19  20  30
        
        int[] start=new int[intervals.length]; 
        int[] end=new int[intervals.length]; 
        
        
        for (int i=0; i < intervals.length; i++){
            
            start[i]=intervals[i][0]; 
            end[i]= intervals[i][1]; 
            
        }
        
        Arrays.sort(start); 
        Arrays.sort(end); 
        int i=0; 
        int j=0;
        int numOfMeetings=0; 
        int res=0; 
        while(i < intervals.length){
            
            if (start[i] < end[j]) {
                i++; 
                numOfMeetings++; 
                
            } else if (start[i] > end[j]) { 
                j++;
                numOfMeetings--; 
                                         
            }
            else{
                
            j++; 
                numOfMeetings--; }
            
            res=Math.max(numOfMeetings,res); 
            
            
            
        }
        
        return res; 
        
        
    }
}