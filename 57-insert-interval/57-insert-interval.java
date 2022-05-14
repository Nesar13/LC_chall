class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // Go trhought slots
        for(int [] slot : intervals) {
             //if newInterval start time is more then interval slot then just insert slot
            // since
            if(newInterval[0] > slot[1]) res.add(slot);
            //if newInterval end time is less then start of interval slot then insert it and update slot to be newInterval
            else if(newInterval[1] < slot[0])  {
                res.add(newInterval);
                newInterval = slot;
            } 
            //if both if faill we know its an overlap and we need to updae start and end.
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }
        //insert last newInterval
        res.add(newInterval);

        return res.toArray(new int [res.size()][]);
    }
}