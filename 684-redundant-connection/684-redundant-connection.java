class Solution {
   public int[] findRedundantConnection(int[][] edges) {
       //max edges is 1000
        int[] parents = new int[edges.length+1]; 
       //map index to node
        for (int i = 0; i < parents.length; i++) parents[i] = i;
       
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            //return the result
            // mathematically, the edge that we add that will be created to create a loop will be found first
            if(find(from, parents) == find(to, parents)) return edge;      
            union(from, to, parents);
        }
        return null;
    }

    //finds the node your looking for 
    private int find(int node, int[] parents) {
        while(node != parents[node])  node = parents[node];
        return node;
    }

    private void union(int a, int b, int[] parents) {
        int aRoot = find(a, parents);
        int bRoot = find(b, parents);
        if(aRoot == bRoot) return;
        //val for the parent index added to current index
        else parents[aRoot] = bRoot;
    }
}