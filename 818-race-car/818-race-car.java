class Solution {
    
    // target=3 
    //  0    1   2   3
    //p:0   1   3   7   2^(n-1) + sum(2^n-i)
    //s:1   2   4   8
    
    public int racecar(int target) {
        
        Deque<int[]> q=new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>(); // position, steps
        q.offer(new int[]{0, 1, 0}); // pos, speed, steps
        
        while (!q.isEmpty()){
            
            int[] curr=q.poll(); 
            
            int pos=curr[0], speed=curr[1], steps=curr[2]; 
            
            if(pos==target) return steps; 
            if(visited.contains(pos + "," + speed)) continue; 
            q.offer(new int[]{pos+speed, speed*2, steps+1});
            
            if(pos+speed > target && speed >0 || pos+speed < target && speed < 0){
                
                speed= speed > 0? -1 : 1;
                q.offer(new int[]{pos, speed, steps+1}); // must add the reversed, and counts as a step
            }
             
             
            
                              
            
            
            
        }
        
        return -1; 
        
        
        
    }
}