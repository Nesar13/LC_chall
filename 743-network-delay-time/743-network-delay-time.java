class Solution {
    
    //We use dijkstra's path finding algorithm to get 
    // the fastest path to all nodes
    // we create an adjacency list : HashMap<Integer, List<List>>
    // so it would be like this: node: {neighbor, timeItTakes}
    // we have to use minheap per dijjstra's ago so we always have the min time it takes
    // and once we visit all nodes, we can return the total time
    // our min heap will look like this with input
    //times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    //  1 <- 2 -> 3 -> 4
    // minheap: [2,0] , [1,1], [3,1], [4,2]
    // notice how the second value is sorted and added from previous values
    // output would be 2 since we will have visited all nodes at 4 with time 2
    // O(V+ELogV) time | O(V+E) space
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        HashMap<Integer, List<List<Integer>>> graph=new HashMap<>(); 
        
        for (int[] t: times){
            graph.putIfAbsent(t[0], new ArrayList<>()); 
            List<Integer> temp=new ArrayList<>(); 
            temp.add(t[1]); 
            temp.add(t[2]); 
            graph.get(t[0]).add(new ArrayList<>(temp)); 
            
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1])); 
        HashSet<Integer> visited=new HashSet<>(); 
        
        pq.offer(new int[]{k,0}); // we insert into pq [node, time]
        while (!pq.isEmpty()){
            
            int s=pq.size(); 

            int[] curr=pq.poll();
            int currNode=curr[0]; 
            int currTime=curr[1]; 
            visited.add(currNode); 
            //if(visited.size() ==n) res=Math.min(res,currTime); 
            // we can just return the first time where we visit all nodes, since that will be the smallest time
            if(visited.size() ==n) return currTime; 
            List<List<Integer>> neighbors=graph.get(currNode); 
            if (neighbors != null) { // we have to check if null since not all the nodes may be keys in our graph
            for (List<Integer> neighbor: neighbors){
                if (visited.contains((neighbor.get(0)))) continue; 
                pq.offer(new int[]{neighbor.get(0), neighbor.get(1)+currTime}); 
                }
            }

        }

        //return visited.size()==n? res: -1; 
        return -1;
    }
}