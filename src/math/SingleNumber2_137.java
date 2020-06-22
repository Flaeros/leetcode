package math;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2_137 {

    public static void main(String[] args) {
        System.out.println(new SingleNumber2_137().singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(new SingleNumber2_137().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0)
                result |= sum << i;
        }

        return result;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, (old, def) -> old + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
}
