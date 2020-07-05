package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays_957 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays_957().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays_957().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        boolean hasCycle = false;
        int cycle = 0;

        Set<String> memo = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int[] next = next(cells);
            String key = Arrays.toString(next);
            if (!memo.contains(key)) {
                memo.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if (hasCycle) {
            N %= cycle;

            for (int i = 0; i < N; i++) {
                cells = next(cells);
            }
        }

        return cells;
    }

    int[] next(int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return tmp;
    }
}
