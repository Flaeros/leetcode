package bit_manipulation;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
        System.out.println(new SingleNumber_136().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new SingleNumber_136().singleNumber(new int[]{4, 2, 1, 1, 2}));
        System.out.println(new SingleNumber_136().singleNumber(new int[]{1, 2, 3, 5, 1, 2, 3}));
    }

    /**
     * {2,1,4,5,2,4,1}     *((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.
     */
    public int singleNumber(int[] nums) {
       int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
