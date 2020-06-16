package bit_manipulation;

public class MissingNumber_268 {

    public static void main(String[] args) {
        System.out.println(new MissingNumber_268().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new MissingNumber_268().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int num = nums.length;

        for (int i = 0; i < nums.length; i++) {
            num = i ^ nums[i] ^ num;
        }
        return num;
    }

    public int missingNumber2(int[] nums) {
        int sum = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }
}
