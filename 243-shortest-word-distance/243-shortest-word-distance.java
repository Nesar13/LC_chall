class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int len=wordsDict.length;
        int minDistance=len; 
        int one=-1; 
        int two=-1;
        for (int i=0; i < wordsDict.length; i++){
            
            if (wordsDict[i].equals(word1)){
                
             one=i;
            }
            
            else if(wordsDict[i].equals(word2)){
                two=i;
            }
            
            if (one != -1 && two != -1){
                minDistance=Math.min(minDistance, Math.abs(one-two));
            }
        }
        
        return minDistance; 
    }
}