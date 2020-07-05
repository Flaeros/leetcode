package bit_manipulation;

public class HammingDistance_461 {

    public static void main(String[] args) {
        System.out.println(new HammingDistance_461().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;

        int result = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                result++;
            }
            z >>= 1;
        }
        return result;
    }
}
