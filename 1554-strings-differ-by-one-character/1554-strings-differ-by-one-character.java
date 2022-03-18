class Solution {
   public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        int len = dict[0].length();
        for(int i = 0; i < len; i++){
            set.clear();
            StringBuilder sb; 
            for(String str: dict){
                sb=new StringBuilder(); 
                sb.append(str.substring(0, i)).append(str.substring(i + 1, len));
                if(set.contains(sb.toString())){
                    return true;
                }
                set.add(sb.toString());
            }
        }
        return false;
    }
}