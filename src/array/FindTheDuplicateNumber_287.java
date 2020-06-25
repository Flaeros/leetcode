package array;

public class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber_287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindTheDuplicateNumber_287().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public int findDuplicate(int[] nums) {
        if (nums.length <= 1)
            return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
