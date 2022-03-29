class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      
            HashSet<Integer>[] graph=new HashSet[numCourses]; 
            int[] indegree=new int[numCourses]; 
      
            for (int i=0; i< numCourses; i++){
                graph[i]=new HashSet<>(); 
            }
            
            for(int[] arr: prerequisites){
                indegree[arr[0]]++; 
                graph[arr[1]].add(arr[0]); 
            }
      
        Deque<Integer> q=new ArrayDeque<>(); 
        
      for (int i=0; i < numCourses; i++){
          if (indegree[i]==0) q.offer(i); 
          
      }
      
      while(!q.isEmpty()){
          
          int curr=q.poll(); 
          
          for (int neighbor: graph[curr]){
              
              indegree[neighbor]--; 
              if(indegree[neighbor]==0) q.offer(neighbor); 
          } 
      }
      
      
      for (int num: indegree){
          if (num != 0) return false; 
      }
      
      
      return true; 
            
        
          
        }
}