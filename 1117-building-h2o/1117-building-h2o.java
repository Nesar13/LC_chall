class H2O {

    
    Semaphore hydro=new Semaphore(2); 
    Semaphore oxy=new Semaphore(0); 
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydro.acquire(); 
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxy.release(); 
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
  
        oxy.acquire(2); 
       
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hydro.release(2); 
    }
}