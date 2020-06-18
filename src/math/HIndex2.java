package math;

public class HIndex2 {

    public static void main(String[] args) {
        System.out.println(new HIndex2().hIndex(new int[]{1, 4, 7, 9})); //3
        System.out.println(new HIndex2().hIndex(new int[]{1, 1, 1, 1, 3, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10})); //6
        System.out.println(new HIndex2().hIndex(new int[]{1, 1, 2, 3, 4, 5, 7})); //3
        System.out.println(new HIndex2().hIndex(new int[]{1, 4, 7, 9})); //3
        System.out.println(new HIndex2().hIndex(new int[]{0, 0, 4, 4})); //2
        System.out.println(new HIndex2().hIndex(new int[]{100})); //1
        System.out.println(new HIndex2().hIndex(new int[]{100, 200})); //2
        System.out.println(new HIndex2().hIndex(new int[]{1})); //1
        System.out.println(new HIndex2().hIndex(new int[]{0, 0, 0, 1, 2})); //1
        System.out.println(new HIndex2().hIndex(new int[]{0, 1, 3, 5, 6})); //3
        System.out.println(new HIndex2().hIndex(new int[]{0, 1, 2, 2, 3})); //2
    }

    public int hIndex(int[] c) {
        int len = c.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rest = len - mid;
            if (c[mid] == rest) {
                return c[mid];
            } else if (c[mid] < rest) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return len - right - 1;
    }
}
