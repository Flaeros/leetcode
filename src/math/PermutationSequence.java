package math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3)); //213
        System.out.println(new PermutationSequence().getPermutation(4, 9)); //2314
        System.out.println(new PermutationSequence().getPermutation(4, 14)); //3142
    }

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            factorials[i] = fact;
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int index = k / factorials[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k-=index * factorials[n-i];
        }

        return sb.toString();
    }
}
