package array;

public class SearchInRotatedArray2_81 {


    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray2_81().search(new int[]{3, 1, 1, 1, 1}, 3));
        System.out.println(new SearchInRotatedArray2_81().search(new int[]{3, 1}, 1));
        System.out.println(new SearchInRotatedArray2_81().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedArray2_81().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

    public boolean search(int[] a, int num) {

        int len = a.length;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num == a[mid])
                return true;
            if (a[start] < a[mid]) {
                if (a[mid] < num || num < a[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (a[start] > a[mid]) {
                if (num < a[mid] || a[end] < num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                start++;
            }
        }

        return false;
    }
}
