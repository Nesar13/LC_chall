import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Lc210_CourseScheduleII_M {

    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList[] graph = new ArrayList[numCourses];

        int[] prereqFreq = new int[numCourses];

        Boolean [] visited=new Boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            graph[i]=new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        }

        return prereqFreq;


    }
}
