package bit_manipulation;

public class PowerOfTwo_231 {

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo_231().isPowerOfTwo(1));
        System.out.println(new PowerOfTwo_231().isPowerOfTwo(16));
        System.out.println(new PowerOfTwo_231().isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        int count = 0;

        while (n > 0) {
            if (count > 1)
                return false;
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }

        return count == 1;
    }
}
