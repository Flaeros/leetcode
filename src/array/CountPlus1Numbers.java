package array;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * <p>
 * If there're duplicates in arr, count them seperately.
 */
public class CountPlus1Numbers {


    /**
     * 1 <= arr.length <= 1000
     * 0 <= arr[i] <= 1000
     */
    public static void main(String[] args) {
        System.out.println(new CountPlus1Numbers().countElements(new int[]{1, 2, 3}));
        System.out.println(new CountPlus1Numbers().countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        System.out.println(new CountPlus1Numbers().countElements(new int[]{1, 3, 2, 3, 5, 0}));
        System.out.println(new CountPlus1Numbers().countElements(new int[]{1, 1, 2, 2, 1000}));
        System.out.println(new CountPlus1Numbers().countElements(new int[]{405,220,238,143,795}));

    }

    public int countElements(int[] arr) {
        int count = 0;
        int[] hash = new int[1002];

        for (int value : arr) {
            hash[value] = 1;
        }

        for (int value : arr) {
            if ( hash[value + 1] == 1)
                count++;
        }

        return count;
    }
}
