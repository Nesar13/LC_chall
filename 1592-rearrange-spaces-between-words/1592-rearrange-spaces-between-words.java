class Solution {
    public String reorderSpaces(String text) {
        
        int len=text.length(); 
        
        String s=text.strip(); 
        String[] arr= s.split("\\s+"); 
        
        int totalSpaces=0;
        int words=arr.length; 
        
        // count spaces
        for (int i =0; i <len; i++){
            char c=text.charAt(i); 
            if(c==' ') totalSpaces++; 
        }
        if(totalSpaces==0) return text;
      
        if(words ==1) return arr[0] + " ".repeat(totalSpaces);
            
        int averageSpace=totalSpaces/(words-1); 
        int remainder= totalSpaces % (words-1); 
        
        
        StringBuilder sb=new StringBuilder(); 
        
    
        
        for (int i =0 ; i <arr.length-1; i++){
            sb.append(arr[i]).append(" ".repeat(averageSpace)); 
            
        }
        sb.append(arr[arr.length-1]).append(" ".repeat(remainder)); 
    
        
        return sb.toString(); 
        
        
        
    }
}