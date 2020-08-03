package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tree.StringUtils.printDim;

public class CombinationSum_39 {

    public static void main(String[] args) {
        System.out.println(printDim(new CombinationSum_39().combinationSum(new int[]{2, 3, 6, 7}, 7)));
        System.out.println(printDim(new CombinationSum_39().combinationSum(new int[]{2, 3, 5}, 8)));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, List<Integer> temp, List<List<Integer>> result, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(candidates, temp, result, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
