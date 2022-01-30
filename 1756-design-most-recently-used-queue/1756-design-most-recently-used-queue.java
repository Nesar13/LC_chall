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
        
        int temp=q.get(k-1);
        List<Integer> copy=new ArrayList<>(); 
        
        for (int i: q){
            if (i != temp){
                copy.add(i); 
            }
        }
        q=new ArrayList(copy);
        q.add(temp); 
        
        return temp; 
        
     
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */