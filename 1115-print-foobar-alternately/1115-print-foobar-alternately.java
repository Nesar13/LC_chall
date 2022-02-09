class FooBar {
    private int n;
    private boolean foo=true; 
    
    public FooBar(int n) {
        this.n = n;
   
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        synchronized(this){
        while(foo==false) this.wait(); 
     
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            foo=false; 
            this.notifyAll(); 
        }
            
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        synchronized(this){
        while(foo==true) this.wait(); 
       
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foo=true; 
            this.notifyAll(); 
        }

        }
        
    
    }
}