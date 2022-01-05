class BrowserHistory {

    List<String> history; 
    int curr;  
    int size; 
    public BrowserHistory(String homepage) {
        history=new ArrayList(); 
        history.add(homepage); 
        curr=0; 
        size=1; 
    }
    
    public void visit(String url) {
        if (curr+1 <  history.size()) history.set(curr+1, url); 
        else history.add(url); 
        curr++; 
        size=curr+1; 
       
        
        
    }
    
    public String back(int steps) {
        curr=Math.max(curr-steps, 0); 
        return history.get(curr); 
        
        
        
    }
    
    public String forward(int steps) {
        curr=Math.min(curr+steps, size-1); 
        return history.get(curr); 
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */