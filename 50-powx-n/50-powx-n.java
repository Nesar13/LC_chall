class Solution {
    public double myPow(double x, int n) {
        
        
        double res=helper(x, n); 
        
        return n < 0 ? 1/res : res; 
    }
    
    double helper(double x, int n){
        
        if(x==0) return 0; 
        if(n==0) return 1; 
        
        double res=helper(x, n/2); 
        res=res*res; // since we're only calculating half, we need to  multiply remaining which is itself
        return n%2==0 ? res : res*x; 
        
        
    }
}