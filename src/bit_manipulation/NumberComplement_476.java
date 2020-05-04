package bit_manipulation;

public class NumberComplement_476 {

    public static void main(String[] args) {
        System.out.println(new NumberComplement_476().findComplement(5));
    }

    public int findComplement(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 0;


        int k = num;
        int cb = 0;
        while (k > 0) {
            cb++;
            k >>= 1;
        }
        int onesMask = (1 << cb) - 1;

        return (~num) & onesMask;
    }
}
