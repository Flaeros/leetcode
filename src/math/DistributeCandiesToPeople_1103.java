package math;

import java.util.Arrays;

public class DistributeCandiesToPeople_1103 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistributeCandiesToPeople_1103().distributeCandies(7, 4)));
        System.out.println(Arrays.toString(new DistributeCandiesToPeople_1103().distributeCandies(10, 3)));
        System.out.println(Arrays.toString(new DistributeCandiesToPeople_1103().distributeCandies(1000000000, 1000)));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 0;
        int c = 1;

        while (candies > 0) {
            result[i++] += Math.min(candies, c);
            i %= num_people;
            candies -= c;
            c++;
        }

        return result;
    }

}
