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
        
        for (int i=1; i <=n ; i++ ) graph.putIfAbsent(i, new ArrayList<>()); 
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1])); 
        HashSet<Integer> visited=new HashSet<>(); 
        
        pq.offer(new int[]{k,0}); 
        
        int res=Integer.MAX_VALUE; 
        
        while (!pq.isEmpty()){
            
            int s=pq.size(); 
            
            for(int i=0; i <s; i++ ){
               
                int[] curr=pq.poll();
                int currNode=curr[0]; 
                int currTime=curr[1]; 
                visited.add(currNode); 
                if(visited.size() ==n) res=Math.min(res,currTime); 
                for (List<Integer> neighbor: graph.get(currNode)){
                    if (visited.contains((neighbor.get(0)))) continue; 
                    
                    pq.offer(new int[]{neighbor.get(0), neighbor.get(1)+currTime}); 
                    
                   
                }
                
            }
            
        }
        
        
        return visited.size()==n? res: -1; 
        
    }
}