class Solution {
   public boolean differByOne(String[] dict) {
  Set <String> str = new HashSet<>();
  //["abcd","acbd", "aacd"]
  for(String w : dict) { //n
    for(int i=0; i<w.length(); i++) { //m
      String word = w.substring(0,i) + "$" + w.substring(i+1);
      if(str.contains(word)) return true;
      else 
        str.add(word);
    }
  }
  return false;

}
}