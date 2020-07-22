package math;

import java.util.ArrayList;
import java.util.List;

import static tree.StringUtils.printDim;

public class Permutations_46 {

    public static void main(String[] args) {
        System.out.println(printDim(new Permutations_46().permute(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
