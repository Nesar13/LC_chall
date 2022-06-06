class Solution {
    
    //Your input
// [1,0,2]
// stdout
// [1, 1, 2]
    public int candy(int[] ratings) {
        
        int[] res=new int[ratings.length]; 
        
        Arrays.fill(res, 1); 
        
        // 1 3 3 5
        // 1 2 1 2
        
        // 1 3 6 5
        // 1 2 3 1
        
        
        for (int i=1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1]) res[i]=res[i-1]+1; 
            
        }
        // for ca
         for (int i=ratings.length-2; i >=0 ; i--){
            
            if (ratings[i] > ratings[i+1]) res[i]=Math.max(res[i], res[i+1]+1);
        }
        
        //System.out.println(Arrays.toString(res)); 
        int sum=0; 
        for (int r: res){
            sum+=r; 
        }
        
        return sum; 
        
        
        
        
    }
}