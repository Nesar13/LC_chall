import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Lc210_CourseScheduleII_M {

    public static void main(String[] args) {

        // [[1,0],[2,0],[3,1],[3,2]]
        // [0,1,2,3,]
        //

        int [][] arr= {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(4, arr));


    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];

        int[] res = new int[numCourses];

        Boolean[] visited = new Boolean[numCourses];
        Boolean[] dp = new Boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);

        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prerequisites, visited, dp, res, graph, 0)) {

                int[] temp = new int[0];
                return temp;
            }

        }
        return res;
    }

    private static boolean dfs(int course, int[][] prerequisites, Boolean[] visited, Boolean[] dp, int[] res, ArrayList[] graph, int count) {

        if (visited[course]) {
            return dp[course];
        } else visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {

            if (!dfs((int) graph[course].get(i), prerequisites, visited, dp, res, graph, count)) {

                dp[course] = false;
                return false;
            } else res[count++] = (int) graph[course].get(i);

        }

        dp[course] = true;
        return true;
    }
}
