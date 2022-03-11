class Solution {
    public String reverseOnlyLetters(String s) {
        int left=0; 
        int right=s.length()-1; 
        char[] arr=s.toCharArray();  
        while (left < right){
            
            if(Character.isLetter(arr[left]) && Character.isLetter(arr[right])){
                
                char temp=arr[left]; 
                arr[left]=arr[right];
                arr[right]=temp; 
                left++; 
                right--; 

            }
            else if(!Character.isLetter(arr[left])) left++; 
            else right--; 
            
        }
        
        
        return String.valueOf(arr);  
        
    }
}