class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int[] start=new int[intervals.length]; 
        int[] end=new int[intervals.length]; 
        
        
        for (int i=0; i < intervals.length; i++){
            
            start[i]=intervals[i][0]; 
            end[i]= intervals[i][1]; 
            
        }
        
        Arrays.sort(start); 
        Arrays.sort(end); 
        int i=0; // start time pointer
        int j=0; // end time pointer
        int numRooms=0; 
        int res=0; 
        while(i < intervals.length){
            // means we need an additional meeting room since
            // start is lower than end time
            if (start[i] >= end[j]) {
                j++; 
                numRooms--; 
                
            } 
           
            numRooms++; 
            i++; 
          

        }
        
        return numRooms; 
        
        
    }
}