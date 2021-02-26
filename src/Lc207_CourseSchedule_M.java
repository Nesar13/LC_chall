import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lc207_CourseSchedule_M {


    // bfs with graph solution, we create a graph structure link with arraylists
    // we can use an array for the degrees to check the number of indegrees
    // and add it to queue
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            //incrementing the number of prereq that appears
            degree[prerequisites[i][1]]++;
            // this will add the prereq associated with it's course to a list of list
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < degree.length; i++) {

            // look for course with no indegree, meaning it is not a prereq
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                // check each prereq and decrement since we have seen it already
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;
    }

    // Graph solution using dfs + dp memoization
    // we create a dfs by creating a boolean array of visited courses
    // and a dp array to store the result
    // we go through each of the graph links to see if there's any cycle
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];

        // create the graph link
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        // check all courses if
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp))
                return false;
        }
        return true;
    }


    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {

        // if we have already visited this course
        // then we return the result of the dp that we stored
        if (visited[course])
            return dp[course];
        else
            visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {

            if (!dfs(graph, visited, (int) graph[course].get(i), dp)) {
                dp[course] = false;
                return false;
            }
        }
        // we will only reach here if there are no prereq for this course or everything
        // returned is true so we set this course to true
        dp[course] = true;
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 1}, {1, 0}, {1, 3}};
        System.out.println(canFinish2(4, nums));


    }
}
