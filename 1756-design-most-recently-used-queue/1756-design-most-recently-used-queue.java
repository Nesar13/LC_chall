class MRUQueue {
 
    List<Integer> q; 
    int s; 
    public MRUQueue(int n) {
        q=new ArrayList<>(); 
        s=n; 
        
        for (int i=0; i < s; i++){
            
            q.add(i+1); 
            
        }
    }
    
    public int fetch(int k) {
        
        if (k==s) return q.get(k-1); 
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