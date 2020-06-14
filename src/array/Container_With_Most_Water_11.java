package array;

public class Container_With_Most_Water_11 {

    public static void main(String[] args) {
        System.out.println(new Container_With_Most_Water_11().maxArea(new int[]{1, 2, 1}));
        System.out.println(new Container_With_Most_Water_11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2)
            return 0;

        int i = 0;
        int j = n - 1;
        int water = 0;

        while (i < j) {
            water = Math.max(water, (j - i) * Math.min(height[j], height[i]));

            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }
}
