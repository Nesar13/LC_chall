class Solution {
    
    // 1) we first determine the angles of the points from our location which is determined from theta=arctan(y/x)
    // 2) then we can use a sliding window to find the difference of the end and start of window to find 
    // the points that are in our field of view
    // O(nlogn) time | O(n) space
public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point, we know if our point and this other point are in same location
                count++;
                continue;
            } 
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI)); // arctangent because tan(theta)=y/x, so theta=arctan(y/x);, and in radians 
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge cases
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1); // count are the points in your location, and i and j are the size of window
        }
        return res;
    }
}