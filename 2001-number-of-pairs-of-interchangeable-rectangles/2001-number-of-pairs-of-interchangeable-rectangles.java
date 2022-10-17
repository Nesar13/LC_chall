class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        HashMap<Double,Long> map=new HashMap<>(); 
        
        for (int[] r: rectangles){
            
            double val=1.0*r[0]/r[1];
            map.put(val, map.getOrDefault(val,0L)+1L);
            
        }
        
        long res=0; 
        for (double key: map.keySet()){
            long val=map.get(key); 
            if (val>1) res+= (val*(val-1))/(2); 
            
            
        }
        
        return res; 
        
        
        
    }
}