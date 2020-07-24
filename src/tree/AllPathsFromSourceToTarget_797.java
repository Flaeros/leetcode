package tree;

import java.util.ArrayList;
import java.util.List;

import static tree.StringUtils.printDim;

public class AllPathsFromSourceToTarget_797 {

    public static void main(String[] args) {
        System.out.println(printDim(new AllPathsFromSourceToTarget_797().allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {}})));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] links) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(links, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[][] links, List<List<Integer>> result, List<Integer> path, int vertice) {
        path.add(vertice);

        if (links.length - 1 == vertice) {
            result.add(path);
            return;
        }

        for (int next : links[vertice]) {
            List<Integer> nextPath = new ArrayList<>();
            nextPath.addAll(path);
            dfs(links, result, nextPath, next);
        }
    }
}
