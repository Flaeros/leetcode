package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class TownJudje_997 {

    public static void main(String[] args) {
        System.out.println(new TownJudje_997().findJudge(2, new int[][]{{1, 2}}));
        System.out.println(new TownJudje_997().findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(new TownJudje_997().findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(new TownJudje_997().findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        System.out.println(new TownJudje_997().findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        System.out.println(new TownJudje_997().findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}}));
        System.out.println(new TownJudje_997().findJudge(11, new int[][]
                {{1, 8}, {1, 3}, {2, 8}, {2, 3}, {4, 8}, {4, 3}, {5, 8}, {5, 3}, {6, 8}, {6, 3}, {7, 8}, {7, 3}, {9, 8}, {9, 3}, {11, 8}, {11, 3}}));
    }

    /**
     * 1 <= N <= 1000
     * trust.length <= 10000
     * trust[i] are all different
     * trust[i][0] != trust[i][1]
     * 1 <= trust[i][0], trust[i][1] <= N
     */
    public int findJudge(int N, int[][] trusts) {
        int[] memo = new int[N+1];

        for (int[] trust : trusts) {
            memo[trust[0]]--;
            memo[trust[1]]++;
        }

        int k = 0;
        for (int i = 0; i <= N; i++) {
            if(memo[i] == N-1)
                return i;
        }
        return -1;
    }

    public int findJudge2(int N, int[][] trusts) {
        if (trusts.length == 0 && N == 0)
            return -1;
        if (trusts.length == 0 && N == 1)
            return 1;

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] trust : trusts) {
            Set<Integer> set = map.getOrDefault(trust[0], new HashSet<>());
            set.add(trust[1]);
            map.put(trust[0], set);
        }

        if (map.size() + 1 != N)
            return -1;

        int judje = -1;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            boolean trustsJudje = false;
            for (Integer trust : entry.getValue()) {
                if (!map.containsKey(trust)) {
                    judje = trust;
                    trustsJudje = true;
                    break;
                }
            }
            if (!trustsJudje)
                return -1;
        }

        return judje;
    }

}
