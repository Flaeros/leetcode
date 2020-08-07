package math;

public class PowerOfFour_342 {

    public static void main(String[] args) {
        System.out.println(new PowerOfFour_342().isPowerOfFour(5));
        System.out.println(new PowerOfFour_342().isPowerOfFour(16));

    }

    public boolean isPowerOfFour(int num) {
        int bitCount = Integer.bitCount(num);
        if (bitCount != 1)
            return false;

        return Integer.toBinaryString(num).length() % 2 == 1;
    }
}
