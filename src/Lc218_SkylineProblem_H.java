import java.util.*;

public class Lc218_SkylineProblem_H {


    //There are several things to consider:
    // 1) we need to consider that the leftmost and rightmost are
    // very important key points so we always track them in
    // in a new list of array called height
    //
    // 2) we  consider a change in the height from previous height
    // to be an important point so we have to use a running variable
    // to keep track of prev and curr height
    //
    // 3) sort the height array by left side, if equal, sort by right side
    // 4) use a treemap since removal is O(lg n ) instead of priorityqueue to keep track
    // of height
    // 5) for current running point, we ust get the
    // highest height in map using map.lastkey()
    // which returns the biggest number in map and the current x-point
    //

    //
    //
    //Example of algortihm:
    // input: [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]

    // []height: [first value is x axis, second is the height]
    // [[2,-10], [9,10], [3,-15], [7,15], [5,-12], [12,12] ..etc.

    // sorted height by leftmost:
    // [[2,-10], [3,-15], [5,-12], [7,15], [9,10], [12,12],etc.]

    // treemap <key: height, value: frequency of this height>:
    // after inserting [5,-12]
    // [0,1], [10,1], [15,1]
    //
    //result: after 3 insertions
    // [[2,10], [3,15], [7,12]

    public static  List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            // start point has negative height value
            height.add(new int[]{building[0], -building[2]});
            // end point has normal height value
            height.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        // Use a maxHeap to store possible heights
        // But priority queue does not support remove in lgn time
        // treemap support add, remove, get max in lgn time, so use treemap here
        // <key: height, value: frequency of this height>
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        pq.put(0, 1);
        // Before starting, the previous max height is 0;
        int prev = 0;
        // visit all points in order
        for (int[] h : height) {
            // a start point, add height
            if (h[1] < 0) {
                pq.put(-h[1], pq.getOrDefault(-h[1], 0) + 1);
            } else {  // a end point, remove height
                // instances where we have two buildings with same height
                // subtract one freq from map
                if (pq.get(h[1]) > 1) {
                    pq.put(h[1], pq.get(h[1]) - 1);
                } else {
                    pq.remove(h[1]);
                }
            }
            int cur = pq.lastKey();
            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if (cur != prev) {
                res.add(new ArrayList(Arrays.asList(h[0], cur)));
                prev = cur;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        //nput: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
        //Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]

        int[][] input=new int [][] {{2,9,10}, {3,7,15},{5,12,12},{15,20,10},{19,24,8} };

            System.out.println(getSkyline(input));



    }
}
