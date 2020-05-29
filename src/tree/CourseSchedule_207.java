package tree;

import static array.MaximalSquare_221.printDim;

public class CourseSchedule_207 {

    public static void main(String[] args) {
        System.out.println(new CourseSchedule_207().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new CourseSchedule_207().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new CourseSchedule_207().canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] graph = new int[numCourses][numCourses];

        for (int[] edge : prerequisites) {
            graph[edge[0]][edge[1]] = 1;
        }

        System.out.println(printDim(graph));

        int[] visited = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(graph, course, numCourses, visited)) {
                return false;
            }
        }

        System.out.println(printDim(graph));
        return true;
    }

    /**
     * 0 - no edge
     * 1 - edge
     *
     * 0 - unvisited
     * 1 - visiting
     * 2 - visited
     */

    private boolean dfs(int[][] graph, int course, int numCourses, int[] visited) {
        if (visited[course] == 1) {
            return false;
        }

        if (visited[course] == 2) {
            return true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (graph[course][i] == 1) {
                visited[course] = 1; // set visiting

                if (!dfs(graph, i, numCourses, visited))
                    return false;

                visited[course] = 2; // set visited
            }

        }

        return true;
    }
}
