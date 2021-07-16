import java.util.HashMap;
import java.util.Map;

public class Lc447_NumberOfBoomerangs_M {

    // we store the distance and the frequency of those distances in a hashmap
    // note that for distance, you don't have to calculate the square root...
    // distance=sqrt((x2-x1)^2 + (y2-y1)^2))
    // we then have to multiply the freq * freq-1 since that is number of
    // permutations we will have for a given frequency
    // O(n^2) time |  O(n) space
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for(int val : map.values()) {
                res += val * (val-1);
            }
            // we don't want to count to count distances twice
            map.clear();
        }

        return res;
    }

    private static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }


    public static void main(String[] args) {


        int[][] arr= {{0,0},{1,0},{2,0}};


        System.out.println(numberOfBoomerangs(arr));
    }
}
