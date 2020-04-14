package array;

import java.util.HashMap;
import java.util.Map;

public class ContigiousArray_525 {
    public static void main(String[] args) {
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1, 0, 1}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1, 0}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 0}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{1, 0, 0, 0, 1, 1, 1, 1}));
        System.out.println(new ContigiousArray_525().findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        int result = 0;
        int y = 0;

        //map y to x
        Map<Integer, Integer> coords = new HashMap<>();
        coords.put(0, -1);

        for (int x = 0; x < nums.length; x++) {
            int num = nums[x];
            if (num == 1)
                y++;
            else
                y--;

            if (coords.containsKey(y))
                result = Math.max(result, x - coords.get(y));
            else
                coords.put(y, x);
        }

        return result;
    }

    public int findMaxLengthN2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroes = 0;
            int ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    zeroes++;
                if (nums[j] == 1)
                    ones++;
                if (zeroes == ones)
                    max = Math.max(max, ones + zeroes);
            }
        }

        return max;
    }
}
