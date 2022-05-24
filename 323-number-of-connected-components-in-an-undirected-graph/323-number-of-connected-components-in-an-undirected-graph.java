class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int[] arr=new int[n]; 
        boolean[] visited=new boolean[n];
        int res=0; 
        for (int i=0; i < n; i++) arr[i]=i; 
                
        for (int[] e: edges){
            
            int x=find(arr, e[0]); 
            int y=find(arr, e[1]); 
            if(x != y ) n--; 
            
           union(arr,x,y); 
            
        }
        

        return n; 
     
        
    }
    
    
    
    int find(int[] arr, int x){
        while(x != arr[x]) x=arr[x]; 
        return x; 
    }
    
    void union(int[] arr, int parent, int child){
        
        int x=find(arr, parent);
        int y=find(arr, child); 
        
        if (x != y){
            arr[y]=x; 
        }
        
    }

}