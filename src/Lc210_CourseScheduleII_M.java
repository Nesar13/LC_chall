import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc210_CourseScheduleII_M {



    public static void main(String[] args) {

        // [[1,0],[2,0],[3,1],[3,2]]
        // [0,1,2,3,]
        //

        int[][] arr = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(4, arr)));


    }
    // Similar to CourseSchedule 1, we set up our boolean visited array, graph array, and dp array
    // we create a new arrayList in the graphs for each course and it's corresponding prereqs
    // we recursively check if we visited each course and add to our result once we are done
    // most likely O(E+V) as we explore each vertex and edge

    static int count = 0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList[] graph = new ArrayList[numCourses];

        int[] res = new int[numCourses];
        // note lower case boolean
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];

        // creating a list inside the array for prereqs
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // creating the prereqs: index is course and the corresponding list is prereqs
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);

        }
        // check each course just in case we miss one
        for (int i = 0; i < numCourses; i++) {
            // if dfs returns false, this means we have a cycle
            if (!dfs(i, visited, dp, res, graph)) {
                return new int[0];
            }
        }
        return res;
    }

    private static boolean dfs(int course,  boolean[] visited, boolean[] dp, int[] res, ArrayList[] graph) {
        // this is to make sure we don't have an overflow
        if (count >= visited.length) return dp[course];

        // we check if we visited the course
        if (visited[course]) {
            // add course if it is not in our result already
            if (!inArray(course, res)) res[count++] = course;
            // return the result of dp
            return dp[course];

        } else visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {

            if (!dfs((int) graph[course].get(i), visited, dp, res, graph)) {
                dp[course] = false;
                return false;
            }
        }
        // since we visited all the prereqs without returning false, we are done with this course
        // we add to result and mark it as viable solution
        res[count++] = course;
        dp[course] = true;
        return true;
    }

    private static boolean inArray(int course, int[] res) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] == course) return true;
        }
        return false;
    }
}
