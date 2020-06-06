package array;

import java.util.*;

import static array.MaximalSquare_221.printDim;

public class QueueReconstructionByHeight_406 {

    public static void main(String[] args) {
        System.out.println(printDim(new QueueReconstructionByHeight_406().reconstructQueue(
                new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    public int[][] reconstructQueueOnStacks(int[][] people) {
        Arrays.sort(people, (o1, o2) -> Integer.compare(o2[0], o1[0]));
        Stack<int[]> main = new Stack<>();
        Stack<int[]> temporary = new Stack<>();

        for (int[] person : people) {
            main.push(person);
        }

        int i = 0;
        Map<Integer, Integer> sizes = new HashMap<>();

        while (!main.isEmpty() || !temporary.isEmpty()) {
            int[] pop = main.pop();
            int peopleBefore = howManyBefore(pop[0], sizes);
            if (peopleBefore == pop[1]) {
                people[i] = pop;
                addSize(pop[0], sizes);
                while (!temporary.isEmpty()) {
                    main.push(temporary.pop());
                }
            } else {
                temporary.push(pop);
            }
        }


        return people;
    }

    private void addSize(int height, Map<Integer, Integer> sizes) {
        sizes.merge(height, 1, (old, newVal) -> old + 1);
    }

    private int howManyBefore(int height, Map<Integer, Integer> sizes) {
        int count = 0;
        for (Integer heightKey : sizes.keySet()) {
            Integer heightCount = sizes.get(heightKey);
            if (heightCount >= height)
                count += heightCount;
        }
        return count;
    }
}
