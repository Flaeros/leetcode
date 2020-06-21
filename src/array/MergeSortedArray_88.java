package array;

import java.util.Arrays;

public class MergeSortedArray_88 {

    public static void main(String[] args) {
        int[] a;
        int[] b;

        a = new int[]{0};
        b = new int[]{1};
        new MergeSortedArray_88().merge(a, a.length - b.length, b, b.length);
        System.out.println(Arrays.toString(a));

        a = new int[]{1, 2, 3, 0, 0, 0};
        b = new int[]{2, 5, 6};
        new MergeSortedArray_88().merge(a, a.length - b.length, b, b.length);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] a, int m, int[] b, int n) {
        int ap = m - 1;
        int bp = n - 1;
        int k = m + n - 1;

        while(ap >= 0 && bp >= 0) {
            if (a[ap] > b[bp]) {
                a[k--] = a[ap--];
            } else {
                a[k--] = b[bp--];
            }
        }

        while (bp >= 0) {
            a[k--] = b[bp--];
        }
    }

    public void merge2(int[] a, int m, int[] b, int n) {
        if (n == 0)
            return;

        int[] c = new int[m + n];
        int ap = 0;
        int bp = 0;
        int cp = 0;

        while (ap < m && bp < n) {
            if (a[ap] < b[bp]) {
                c[cp++] = a[ap++];
            } else {
                c[cp++] = b[bp++];
            }
        }

        while (ap < m) {
            c[cp++] = a[ap++];
        }

        while (bp < n) {
            c[cp++] = b[bp++];
        }

        System.arraycopy(c, 0, a, 0, m + n);
    }
}
