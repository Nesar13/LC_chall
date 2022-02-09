class TrafficLight {

    public int greenRoad=1; 
    public TrafficLight() {
        
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        
        synchronized(this){
            
            Thread turnGreenThread=new Thread(turnGreen); // we need to do this to execute the join() method, so we can to let each car pass one by one
            Thread crossThread=new Thread(crossCar); 
            
            if (greenRoad !=roadId){
                greenRoad=roadId; 
                turnGreenThread.run();
            }
            
            try{
                turnGreenThread.join(); //join waits for the execution of the turnGreen thread to be completed
            }
            catch(InterruptedException e){
                 Thread.currentThread().interrupt();
            }
            
             crossThread.run(); 
            try{
                crossThread.join(); 
                
            } catch(InterruptedException e){
                 Thread.currentThread().interrupt();
            }
            

    }
    
    
    
    
}
}