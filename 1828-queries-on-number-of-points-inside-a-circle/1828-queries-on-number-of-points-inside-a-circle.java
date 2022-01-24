class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] res=new int[queries.length];
        for (int i=0; i < queries.length; i++){
            
            int radius=queries[i][2];
            int currX=queries[i][0]; 
            int currY=queries[i][1];
            int countPoint=0;
            for (int[] point: points){
                int x=point[0]; 
                int y=point[1]; 
                // distance between two points (x1, y1) and (x2, y2) is given by - sqrt((x1 - x2)^2 + (y1 - y2)^2).
                //(circle_center_x - x1) ^ 2 + (circle_center_y - y1) ^ 2 <= r * r
                if (((currX - x)*(currX-x) + (currY - y) * (currY - y)) <= radius*radius){
                    countPoint++; 
                    
                }
                
            }
            
            res[i]=countPoint; 
            
            
        }
        
        
        return res; 
        
    }
}