class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;
        int res=0; 
        
        while( num > 0){
            
            res +=num % 10; 
            num= num/10; 
            if(res < 10 && num==0) return res;
            else if(num==0) {
                num=res;
                res=0; 
            }
        }
        
        
        return res;
        
    }
}