package math;

public class HIndex_274 {
    public static void main(String[] args) {
        System.out.println(new HIndex_274().hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for (int citation : citations) {
            if (citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i)
                return i;
        }

        return 0;
    }
}
