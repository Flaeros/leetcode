package bit_manipulation;

/**
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class ReduceNumber_1342 {

    /**
     * even ends by 0, uneven by 1
     * shift right - divide by 2^n, left - multiply
     */
    public static void main(String[] args) {
        System.out.println(new ReduceNumber_1342().numberOfSteps(14));
        System.out.println(new ReduceNumber_1342().numberOfSteps(13));
        System.out.println(new ReduceNumber_1342().numberOfSteps(8));
        System.out.println(new ReduceNumber_1342().numberOfSteps(123));
        System.out.println(new ReduceNumber_1342().numberOfSteps(12252354));
        System.out.println(new ReduceNumber_1342().numberOfSteps(0));
        System.out.println(new ReduceNumber_1342().numberOfSteps((int) Math.pow(10, 6)));
    }

    public int numberOfSteps(int num) {
        if (num <= 0) return 0;

        String binary = Integer.toBinaryString(num);
        int length = binary.length();

        int bitCount = Integer.bitCount(num);

        return bitCount * 2 + (length - bitCount) - 1;
    }

    public int numberOfStepsAlternative(int num) {
        if (num <= 0) return 0;
        int res = 0;
        while (num > 0) {
            res += (num & 1) > 0 ? 2 : 1;
            num >>= 1;
        }
        return res - 1;
    }
}
