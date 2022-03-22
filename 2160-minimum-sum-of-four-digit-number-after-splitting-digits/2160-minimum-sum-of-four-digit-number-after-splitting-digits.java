class Solution {
    public int minimumSum(int num) {
        
        int[] arr=new int[4]; 
       
        // find two smallest number 2932
 
        
        int i=0; 
        while (num > 0){
            
            int remainder=num % 10; 
            
            num=num/10; 
            
            arr[i++]=remainder; 
            
//             if (remainder < arr[0]) shift(arr, 0, remainder); 
//             else if(remainder < arr[1]) shift(arr, 1, remainder); 
//             else if(remainder < arr[2]) shift(arr, 2, remainder); 
//             else shift(arr, 3, remainder); 
            
            
        }
        Arrays.sort(arr); 
        
        int firstNum=arr[0] * 10 + arr[2]; 
        int secondNum=arr[1]*10 + arr[3]; 
        
        return firstNum+secondNum; 
        
        
        

        
    }
    
   
    void shift(int[] arr, int k, int val){
        int v=val; 
        for (int i=k ; i < arr.length; i++){
            int temp=arr[i]; 
            arr[i]= v; 
            v=temp; 
            
        }
        
    }
}