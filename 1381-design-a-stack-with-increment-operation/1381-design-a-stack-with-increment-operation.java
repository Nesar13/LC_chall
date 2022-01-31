class CustomStack {
    
    List<Integer> lst; 
    int maxSize;
    int currSize; 

    public CustomStack(int maxSize) {
        
        lst=new ArrayList<>(); 
        this.maxSize=maxSize; 
        currSize=0; 
    }
    
    public void push(int x) {
      
        
        if (currSize < maxSize){
            lst.add(x); 
            currSize++; 
        } 
    }
    
    public int pop() {
        if (currSize==0) return -1; 
        return lst.remove((currSize--)- 1); 
        
    }
    
    public void increment(int k, int val) {
            int min=Math.min(k, currSize);
            
            for (int i=0; i< min; i++){
                
                lst.set(i, lst.get(i)+val); 
            }
        }
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */