class BrowserHistory {

    List<String> history; 
    int curr;  
    public BrowserHistory(String homepage) {
        history=new ArrayList(); 
        history.add(homepage); 
        curr=0; 
        
    }
    
    public void visit(String url) {
        history.subList(curr+1, history.size()).clear(); 
        history.add(url); 
        curr++; 
       
        
        
    }
    
    public String back(int steps) {
        curr=Math.max(curr-steps, 0); 
        return history.get(curr); 
        
        
        
    }
    
    public String forward(int steps) {
        curr=Math.min(curr+steps, history.size()-1); 
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