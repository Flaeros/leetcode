package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
 * Given the array groupSizes of length n telling the group size each person belongs to,
 * return the groups there are and the people's IDs each group includes.
 *
 * You can return any solution in any order and the same applies for IDs.
 * Also, it is guaranteed that there exists at least one solution.
 */

public class GroupPeople_1282 {

    /**
     * groupSizes.length == n
     * 1 <= n <= 500
     * 1 <= groupSizes[i] <= n
     */
    public static void main(String[] args) {
        System.out.println(printNested(new GroupPeople_1282().groupThePeople(new int[]{3,3,3,3,3,1,3})));
        System.out.println(printNested(new GroupPeople_1282().groupThePeople(new int[]{2,1,3,3,3,2})));
    }

    private static String printNested(List<List<Integer>> groupThePeople) {
        String result = "[";
        for (List<Integer> groupThePerson : groupThePeople) {
            result += Arrays.toString(groupThePerson.toArray()) + ",";
        }
        return result + "]";
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> groupBySize = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int personIndex = i;
            int groupSize = groupSizes[i];

            List<List<Integer>> groupList;
            groupList = groupBySize.computeIfAbsent(groupSize, k -> new ArrayList<>());

            if (groupList.isEmpty()) {
                ArrayList<Integer> group = new ArrayList<>();
                group.add(personIndex);
                groupList.add(group);
            } else {
                Optional<List<Integer>> anyGroup = groupList.stream().filter(e -> e.size() < groupSize).findAny();
                if (anyGroup.isPresent()) {
                    anyGroup.get().add(personIndex);
                } else {
                    List<Integer> group = new ArrayList<>();
                    group.add(personIndex);
                    groupList.add(group);
                }
            }
        }

        return groupBySize.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
