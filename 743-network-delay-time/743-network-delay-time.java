class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
       
        HashMap<Integer, List<List<Integer>>> graph=new HashMap<>(); 
        
        
        for (int[] t: times){
            graph.putIfAbsent(t[0], new ArrayList<>()); 
            List<Integer> temp=new ArrayList<>(); 
            temp.add(t[1]);
            temp.add(t[2]); 
            graph.get(t[0]).add(new ArrayList<>(temp)); 
            
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1])); 
        HashSet<Integer> visited=new HashSet<>(); 
        
        pq.offer(new int[]{k, 0}); 
        
        
        while (!pq.isEmpty()){
            
            
            int[] curr=pq.poll(); 
            int currNode=curr[0]; 
            int currTime=curr[1];
            visited.add(currNode); 
            if(visited.size() == n) return currTime; 
            
            if(graph.get(currNode) != null){
            for (List<Integer> neighbor: graph.get(currNode)){
                
                if(visited.contains(neighbor.get(0))) continue; 
                pq.offer(new int[]{neighbor.get(0), neighbor.get(1) + currTime}); }
            
            }
            
        }
        
        return -1; 
        
        
    }
}