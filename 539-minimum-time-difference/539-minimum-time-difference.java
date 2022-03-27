class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] arr=new int[timePoints.size()]; 
        int j=0; 
        // cinvert to min
        
        for( String s: timePoints){
            
    
            int hours=Integer.parseInt(s.substring(0, 2)); 
            int minutes=Integer.parseInt(s.substring(3)); 

            
            arr[j++]=hours*60 + minutes; 
            
            
        }
        
        
        // 23*60=
        // sort
        // 5  , 800, 1800
        
        Arrays.sort(arr); 
        
        
        int temp_min=  Math.abs(24 * 60 - arr[timePoints.size()-1]  + arr[0]); 
        int min=Integer.MAX_VALUE; 
         //System.out.println(min);

        for (int i=0; i < arr.length -1 ; i++) {
            
            if (arr[i+1] - arr[i] < min){
                
                min=arr[i+1] - arr[i]; 
            }
            
        }
        
        return Math.min(temp_min, min); 
        
    }
}