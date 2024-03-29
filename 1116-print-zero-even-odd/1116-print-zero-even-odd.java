class ZeroEvenOdd {
    private int n;
    Semaphore z; 
    Semaphore e; 
    Semaphore o; 

    public ZeroEvenOdd(int n) {
        this.n = n;
        
        z=new Semaphore(1, true); 
        e=new Semaphore(0, true); 
        o=new Semaphore(0, true); 
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
       
        for( int i=0; i< n; i++){
            
            z.acquire();
            
            printNumber.accept(0); 
            
            if(i% 2 == 0){
                o.release(); 
            }
            else{
                e.release(); 
            }
            
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
            
                e.acquire();   
                printNumber.accept(i); 
                z.release(); 
            
        
            }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
       for (int i = 1; i <= n; i += 2) {
            o.acquire(); 
            
            printNumber.accept(i); 
           
            z.release(); 
                
    }}
}