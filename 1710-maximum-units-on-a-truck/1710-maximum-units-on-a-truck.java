class Solution {
    
public int maximumUnits(int[][] boxTypes, int truckSize) {
    
    Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1])); 
    
    int res=0; 
    int totalBox=0; 
    for (int[] b: boxTypes){
        
        res+= b[1] * b[0]; 
        truckSize -= b[0]; 
        
        if(truckSize < 0){
            res += b[1] * truckSize; 
            
            break;
        }
        
    }
    
    return res; 
    }
}