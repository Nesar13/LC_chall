class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        
        int len=arrays.length; 
        int[] freq=new int[101];
        List<Integer> res=new ArrayList<>(); 
        
        for( int[] a: arrays){
            
            for (int num: a) {
                freq[num]++; 
                
                if (freq[num]==len) res.add(num); 
            }
        }
            
        
        
    return res; 

    
}
}