class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr); 
        
        int num=(int)Math.floor(arr.length * .05); 
        double mean=0; 
    
        for (int i=num; i< arr.length-num; i++){
            
            mean+= arr[i]; 
        }
      
        mean= mean/(arr.length - (num+num)); 
        
        return mean; 
    }
}