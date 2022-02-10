class BoundedBlockingQueue {
    
    int n; 
  
    Deque < Integer> q; 
    Semaphore en; 
    Semaphore de; 
    public BoundedBlockingQueue(int capacity) {
        n=capacity; 
        q=new ArrayDeque(); 
        en = new Semaphore(n, true); 
        de=new Semaphore(0, true); 
    }
    
    public void enqueue(int element) throws InterruptedException {
        en.acquire(); 
        q.offer(element); 
        
        de.release(); 
    }
    
    public int dequeue() throws InterruptedException {
        
        de.acquire(); 
        
        int temp=q.poll(); 
        
        en.release(); 
        
        return temp; 
        
    }
    
    public int size() {
        
        
        return q.size();
    }
}