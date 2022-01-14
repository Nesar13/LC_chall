class Solution {
    //case1     A       B
    //               C         D
    
    //case2         A       B
    //         C        D
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> res=new ArrayList(); 
        
        int i=0; 
        int j=0; 

        
        
        while(i < firstList.length && j < secondList.length) {
            
     
            int a=Math.max(firstList[i][0], secondList[j][0]); 
            int b=Math.min(firstList[i][1], secondList[j][1]); 
            
            if (a <= b){
                res.add(new int[] {a, b}); 
            }
            if (firstList[i][1] <secondList[j][1]){
                i++;
                
            }
            else
                j++; 
            

        
        
      
    }
        
        return res.toArray(new int[res.size()][]);
        
    }
}
    

