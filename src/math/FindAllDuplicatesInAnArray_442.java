package math;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesInAnArray_442().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int abs = Math.abs(num);
            int index = abs - 1;
            int n = nums[index];
            if (n < 0)
                result.add(abs);
            nums[index] = -nums[index];
        }
        return result;
    }
}
