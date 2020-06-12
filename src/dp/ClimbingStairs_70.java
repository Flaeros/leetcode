package dp;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs_70().climbStairs(1));
        System.out.println(new ClimbingStairs_70().climbStairs(2));
        System.out.println(new ClimbingStairs_70().climbStairs(3));
        System.out.println(new ClimbingStairs_70().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int prev = 0;
        int curr = 1;

        for (int i = 0; i < n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
