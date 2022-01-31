class CustomStack {
    
    List<Integer> lst; 
    int[] inc; 
    int maxSize;
    int currSize; 

    public CustomStack(int maxSize) {
        
        lst=new ArrayList<>(); 
        this.maxSize=maxSize; 
        currSize=0; 
        inc=new int[maxSize]; 
    }
    
    public void push(int x) {
      
        
        if (currSize < maxSize){
            lst.add(x); 
            currSize++; 
        } 
    }
    
    public int pop() {
        if (currSize==0) return -1; 
        
        if (currSize -2 >= 0) {
            
            inc[currSize-2] += inc[currSize-1]; 
        }
        
        int res=inc[currSize-1] + lst.remove((currSize)- 1); 
        inc[currSize-1]=0; 
        currSize--; 
       
        return  res;  
        
    }
    
    public void increment(int k, int val) {
            int min=Math.min(k, currSize);
            
            if(min-1 >=0){
                inc[min-1] +=val; 
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