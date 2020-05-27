package array;

public class PossibleBipartition_886 {

    public static void main(String[] args) {
        System.out.println(new PossibleBipartition_886().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(new PossibleBipartition_886().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(new PossibleBipartition_886().possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4},
                {4, 5}, {5, 1}}));
        System.out.println(new PossibleBipartition_886().possibleBipartition(10,
                new int[][]{{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5},
                        {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));

    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];

        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }

        int[] groups = new int[N];

        for (int i = 0; i < N; i++) {
            if (groups[i] == 0 && !dfs(graph, groups, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] groups, int index, int group) {
        groups[index] = group;

        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (groups[i] == group) {
                    return false;
                }
                if (groups[i] == 0 && !dfs(graph, groups, i, -group)) {
                    return false;
                }
            }
        }

        return true;
    }
}
