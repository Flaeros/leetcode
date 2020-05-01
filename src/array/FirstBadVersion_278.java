package array;

public class FirstBadVersion_278 {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion_278().firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (high > low) {
            n = low + (high - low) / 2;

            if (isBadVersion(n)) {
                high = n;
            } else {
                low = n + 1;
            }
        }
        return low;
    }


    boolean isBadVersion(int n) {
        if (n >= 1702766719)
            return true;
        return false;
    }
}
