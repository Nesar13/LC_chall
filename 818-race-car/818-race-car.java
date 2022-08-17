class Solution {
    
    // target=3 
    //    0   1   2   3
    //pos:0   1   3   7   
    //spe:1   2   4   8
    
    // We can do a BFS solution if we realize that the positions are interconnected, if we reverse
    // we just add that to the queue(position, speed, steps)
    // We also have to store a visited array of the position and speed so we don't revisit the same
    // numbers
    // O(targetlog(target)) time | , could have visited every single position in both the directions i.e. from  
    // target to +target so the total no of positions possible are O(target), but since we are reaching target 
    // bounded by speed from 1,2,4,8... up to target, the total number of DISTINCT SPEEDS are O(log(target))
    // Hence time complexity= Total distinct positions(target) * total distinct speeds (log(target)) = O(targetlog(target)).
    public int racecar(int target) {
        
        Deque<int[]> q=new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>(); // position, speed
        q.offer(new int[]{0, 1, 0}); // pos, speed, steps
        
        while (!q.isEmpty()){
            
            int[] curr=q.poll(); 
            
            int pos=curr[0], speed=curr[1], steps=curr[2]; 
            
            if(pos==target) return steps; 
            if(visited.contains(pos + "," + speed)) continue; 
            q.offer(new int[]{pos+speed, speed*2, steps+1}); // must add new pos and speed
            
            if(pos+speed > target && speed >0 || pos+speed < target && speed < 0){
                
                speed= speed > 0? -1 : 1;
                q.offer(new int[]{pos, speed, steps+1}); // must add the reversed, and counts as a step
            }

        }
        
        return -1; 
        
        
        
    }
}