class Solution {
    
    // We need to realize that that the path we take, the highest number will be the maxDepth
    // so We can use dijkstra's with a priorityqueue so we can continually
    // use the path that has the smallest depth
    //Our priority queue will have [i,j,maxDepthSoFar] in a min heap
    // O(n^2logN) time since we may visit each node n times and logn for heap operations
    // O(n^2) space
    private int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, grid[0][0]}); // x,y, depthSoFar
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            for(int[] d: dir) {
                int x = curr[0] + d[0], y = curr[1] + d[1];
                if(x < 0 || x >= n || y < 0 || y >= n) continue;
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    int maxDepthSoFar = Math.max(curr[2], grid[x][y]); // we just have to store maxDepth so far
                    if(x == n-1 && y == n-1) return maxDepthSoFar;
                    pq.add(new int[] {x, y, maxDepthSoFar});
                }
            }
        }
        return 0;
    }
}