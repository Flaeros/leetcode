package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static tree.StringUtils.printDim;

public class Subsets2_90 {

    public static void main(String[] args) {
        System.out.println(printDim(new Subsets2_90().subsetsWithDup(new int[]{4,4,4,1,4})));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int level) {
        list.add(new LinkedList<>(tempList));
        for (int i = level; i < nums.length; i++) {
            if (i != level && i > 0 && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
