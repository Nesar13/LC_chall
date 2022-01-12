class Solution {
      public int[] findOriginalArray(int[] changed) {
        
            
        if(changed.length%2!=0) return new int[0];
        
        int mid = changed.length/2;
        
        int[] res = new int[mid];
        
        int[] freq = new int[100001];
        
        for(int no : changed)
            freq[no]++;
        
        
        int idx=0;
        
        for(int i=0; i<freq.length; i++){
            
            while(freq[i] > 0 && i*2 < 100001 && freq[i*2]>0){
                freq[i]--;
                freq[i*2]--;
                res[idx++] = i;
            }
        }
        
        for(int i=0; i<freq.length; i++){
            if(freq[i]!=0) return new int[0];
        }
        
        return res;
        

    }
}