package bit_manipulation;

public class ReverseBits_190 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(new ReverseBits_190().reverseBits(-3))); // -1073741825

        System.out.println();

        System.out.println(Integer.toBinaryString(43261596));
        System.out.println(Integer.toBinaryString(new ReverseBits_190().reverseBits(43261596))); // 964176192

    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;

            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }

    public int reverseBits2(int n) {
        for (int i = 0; i < 16; i++) {
            int rightPos = 1 << i;
            int right = n & rightPos;

            int leftPos = 0x80000000 >>> i;
            int left = n & leftPos;

            if (right == 0) {
                n &= ~leftPos;
            } else {
                n |= leftPos;
            }

            if (left == 0) {
                n &= ~rightPos;
            } else {
                n |= rightPos;
            }
        }

        return n;
    }
}
