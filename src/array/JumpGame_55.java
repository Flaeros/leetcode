package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class JumpGame_55 {

    public static void main(String[] args) {
        System.out.println(new JumpGame_55().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame_55().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new JumpGame_55().canJump(new int[]{3, 2, 1, 5, 4}));
        System.out.println(new JumpGame_55().canJump(new int[]{9, 2, 0, 0, 0, 0, 0, 4}));
        System.out.println(new JumpGame_55().canJump(new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2,
                2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3,
                0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
