class Solution {
    

    
    // we can set up a graph relationship
    // for example, if we take a b c
    // where a/b = 2, b/c=3
    // we can set up our graph like this: 
    //      2     3 
   // a ->  b ->  c
   //1/2   1/3     
   // if we go from a to c, we just have multiply the values across so 2*3 to get a/c
   // if we go from c to a, we just have to inverse the valuese so 1/2 * 1/3 to get c/a
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, HashMap<String, Double>> graph=new HashMap<>(); 
        
        for (int i=0; i< equations.size(); i++){
            List<String> e=equations.get(i); 
            
            String dividend = e.get(0); 
            String divisor=e.get(1); 
            
            double val=values[i]; 
            
            graph.putIfAbsent(dividend, new HashMap<>()); 
            graph.putIfAbsent(divisor, new HashMap<>()); 
            
            graph.get(dividend).put(divisor, val); 
             graph.get(divisor).put(dividend, 1/val);
                
            
            
        }
        
        double[] res=new double[queries.size()]; 
        
        for (int i=0; i< queries.size(); i++){
            
            List<String> q=queries.get(i); 
            
            String dividend = q.get(0); 
            String divisor=q.get(1); 
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                res[i]=-1; 
            }
            else if (dividend == divisor)
                res[i] = 1.0;
            else{
                HashSet<String> visited=new HashSet(); 
                res[i]=backtrack(graph, dividend, divisor, 1 , visited);
            }
            
        }
        
        return res; 
        
        
        
        
    }
    
    double backtrack(HashMap<String, HashMap<String, Double>> graph, 
                     String currNode, String targetNode, double accProduct, Set<String> visited ){
        
       visited.add(currNode); 
        double res=-1.0; 
        
        Map<String, Double> neighbors = graph.get(currNode); 
        
        if (neighbors.containsKey(targetNode))
            res=accProduct * neighbors.get(targetNode); 
        else {
            
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode=pair.getKey(); 
                if(visited.contains(nextNode))
                    continue; 
                res=backtrack(graph, nextNode, targetNode, accProduct * pair.getValue(), visited);
                
                if(res != -1.0) 
                    break; 
                
            }
        }
        
        //visited.remove(currNode); 
        return res; 
    }
    
    
    
    
}