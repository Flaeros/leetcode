package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2_210 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseSchedule2_210().findOrder(2, new int[][]{
                {0, 1}, {1, 0}})));
        System.out.println(Arrays.toString(new CourseSchedule2_210().findOrder(2, new int[][]{
                {1, 0}})));
        System.out.println(Arrays.toString(new CourseSchedule2_210().findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] incoming = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int to = prerequisite[0];
            int from = prerequisite[1];
            graph[from][to] = 1;

            incoming[to]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (incoming[i] == 0)
                q.offer(i);
        }

        int[] result = new int[numCourses];

        int order = 0;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            Integer vertice = q.poll();
            result[order++] = vertice;

            for (int i = 0; i < numCourses; i++) {
                if (graph[vertice][i] == 1) {
                    incoming[i]--;
                    graph[vertice][i] = 0;

                    if (incoming[i] == 0)
                        q.offer(i);
                }
            }
        }

        if (count != numCourses)
            return new int[]{};

        return result;
    }
}
