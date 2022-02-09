class Solution {
    

    
    
    
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result=new ArrayList<>(); 
        
        int len=words.length; 
        
        int i=0; 
        
        StringBuilder sb=new StringBuilder(); 
        sb.append(words[0]); 
         
        
        while (i < len){
            int j=i+1;
           int currWidth=words[i].length();
            // j-i-1 represents the number of spaces that should be added from words i to j
            // calcualtes the num of char that can be added on the current line 
            while (j < len && (currWidth + words[j].length() + j - i - 1) < maxWidth){
                currWidth+= words[j].length(); 
                j++; 
            }
            
            int extraSpaceNeeded= maxWidth - currWidth; 
            int numOfWords=j-i; 
            
            // per requirement, if we only have one word or if it's the last line
            // we left justify, meaning no extraspaces on left, but on right
            if (numOfWords==1 || j >=len){
                result.add(leftJustify(words, extraSpaceNeeded, i, j));
            }
            else 
                result.add(middleJustify(words, extraSpaceNeeded, i, j)); 
            
            i=j ;
            }
        
        return result; 
            
            
            
            
        }
        
    
    
    
    public String leftJustify(String[] words, int extraSpaceNeeded, int i, int j){
        int spacesOnRight=extraSpaceNeeded-(j-i-1); 
        
        StringBuilder result = new StringBuilder(words[i]); 
        
        for (int k=i +1; k < j; k++){
            result.append(" " + words[k]); 
            
        }
        result.append(" ".repeat(spacesOnRight)); 
        return result.toString(); 
        
        
    }
    
    
    public String middleJustify(String[] words, int extraSpaceNeeded, int i, int j) {
        int sections=j-i-1; // the number of sections(e.g. number of words)
        int spaces=extraSpaceNeeded/sections; //the average amount of spaces to apply in each section
        int extraSpaces= extraSpaceNeeded % sections; // if there's a remainder of space to apply
        
        
        StringBuilder result= new StringBuilder(words[i]); 
        
        for (int k=i +1; k< j; k++){
            int spacesToApply=spaces+(extraSpaces-- > 0 ? 1: 0); 
            result.append(" ".repeat(spacesToApply) + words[k]); 
            
            
        }
        return result.toString(); 
        
    }
    
    
    
    }
