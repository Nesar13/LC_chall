class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        // 0 1 2 3 4 5 
        // 0   1
        int[] arr=new int[edges.length+1] ; 
        
        for (int i=0; i < arr.length; i++)
            arr[i]=i; 

        for (int[] e: edges){
            
            if (find(arr, e[0]) ==find(arr, e[1])) return e; 
            
            union(arr, e[0], e[1]); 
            
        }
        
        return new int[]{0,0}; 
        
        
    }
    
    void union(int[] arr, int x, int y){
        
        int xParent=find(arr, x); 
        int yParent=find(arr, y); 
        
        if (xParent != yParent){
            arr[yParent]=xParent; 
        }
        
        
    }
    
    
    
    
    int find(int[] arr, int x){
        
        while (x != arr[x]){
            x=arr[x]; 
        }
        
        return x; 
    }
}