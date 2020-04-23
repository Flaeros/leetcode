package bit_manipulation;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 */
public class BitwiseAndOfRange_201 {


    public static void main(String[] args) {
        System.out.println(new BitwiseAndOfRange_201().rangeBitwiseAnd(2, 20));
        System.out.println(new BitwiseAndOfRange_201().rangeBitwiseAnd(5, 7));
        System.out.println(new BitwiseAndOfRange_201().rangeBitwiseAnd(0, 1));
        System.out.println(new BitwiseAndOfRange_201().rangeBitwiseAnd(0, 2147483647));
        System.out.println(new BitwiseAndOfRange_201().rangeBitwiseAnd(2147483647, 2147483647));
    }


    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while(m != n){
            m >>= 1;
            n >>= 1;
            i++;
            System.out.println("m,n,i=" + m + "," + n+ "," + i);
        }
        return m << i;
    }

    public int rangeBitwiseAndN2(int m, int n) {
        System.out.println("m,n=" + m + "," + n);
        int res = m;
        int top = top(m, n);
        System.out.println("top = " + top);
        for (int i = m + 1; i <= top; i++) {
            if ( i == Integer.MIN_VALUE)
                break;
            System.out.println("i = " + top);
            res &= i;
            if (i == Integer.MAX_VALUE)
                break;
        }
        return res;
    }

    private int top(int m, int n) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            double pow = Math.pow(2, i);
            if (m < pow)
                if (pow > n)
                    return n;
                else
                    return (int) pow;
        }
        return n;
    }
}
