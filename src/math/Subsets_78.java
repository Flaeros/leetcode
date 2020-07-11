package math;

import java.util.*;

import static tree.StringUtils.printDim;

public class Subsets_78 {

    public static void main(String[] args) {
        System.out.println(printDim(new Subsets_78().subsets(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int index) {
        result.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
