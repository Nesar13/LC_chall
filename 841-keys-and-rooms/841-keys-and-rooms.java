class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean [] arr=new boolean[rooms.size()]; 
        
        dfs(arr, rooms, 0); 
        
        for (boolean room: arr){
            
            if (room==false) return false; 
        }
        
        return true; 
        
    }
    
    void dfs(boolean[] arr, List<List<Integer>> rooms, int room){
        
        if (arr[room]) return; 
        
        arr[room]= true; 
        for (Integer r: rooms.get(room)){
         
                dfs(arr, rooms, r);

        }
        
        return; 
        
    }
}