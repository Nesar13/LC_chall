class MRUQueue {
 
    List<Integer> q; 
  
    public MRUQueue(int n) {
        q=new ArrayList<>(); 
      
        
        for (int i=0; i < n; i++){
            
            q.add(i+1); 
            
        }
    }
    
    public int fetch(int k) {
        
     
        int temp=q.remove(k-1); 
        q.add(temp); 
        
        return temp; 
        
     
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */