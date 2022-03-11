import java.awt.*;
import java.util.*;
import java.util.List;

public class Lc815_BusRoutes_H {




        public int numBusesToDestination(int[][] routes, int S, int T) {
            if (S==T) return 0;
            int N = routes.length;

            List<List<Integer>> graph = new ArrayList();
            for (int i = 0; i < N; ++i) {
                Arrays.sort(routes[i]);
                graph.add(new ArrayList());
            }
            Set<Integer> seen = new HashSet();
            Set<Integer> targets = new HashSet();
            Queue<Point> queue = new LinkedList<>();

            // Build the graph.  Two buses are connected if
            // they share at least one bus stop.
            // so we just put all the buses that bus[i] has access to
            for (int i = 0; i < N; ++i)
                for (int j = i+1; j < N; ++j)
                    if (intersect(routes[i], routes[j])) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }

            // Initialize seen, queue, targets.
            // seen represents whether a node has ever been enqueued to queue.
            // queue handles our breadth first search.
            // targets is the set of goal states we have.
            for (int i = 0; i < N; ++i) {
                if (Arrays.binarySearch(routes[i], S) >= 0) {
                    seen.add(i);
                    queue.offer(new Point(i, 0));
                }
                if (Arrays.binarySearch(routes[i], T) >= 0)
                    targets.add(i);
            }

            while (!queue.isEmpty()) {
                Point info = queue.poll();
                int node = info.x, depth = info.y;
                if (targets.contains(node)) return depth+1;
                for (Integer nei: graph.get(node)) {
                    if (!seen.contains(nei)) {
                        seen.add(nei);
                        queue.offer(new Point(nei, depth+1));
                    }
                }
            }

            return -1;
        }

        public boolean intersect(int[] A, int[] B) {
            int i = 0, j = 0;
            while (i < A.length && j < B.length) {
                if (A[i] == B[j]) return true;
                if (A[i] < B[j]) i++; else j++;
            }
            return false;
        }


    public static void main(String[] args) {
//routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2

        int[][] routes={{1,2,7}, {3,6,7}};

        int source= 1;
        int target=6;
Lc815_BusRoutes_H bus=new Lc815_BusRoutes_H() ;

System.out.println(bus.numBusesToDestination(routes, source, target));


    }
}
