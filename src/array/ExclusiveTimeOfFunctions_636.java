package array;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

public class ExclusiveTimeOfFunctions_636 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions_636().exclusiveTime(2,
                asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")))); // 8,1

        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions_636().exclusiveTime(3,
                asList("0:start:0", "1:start:1", "1:end:2", "2:start:4", "2:end:5", "0:end:6")))); // 3, 2, 2
        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions_636().exclusiveTime(3,
                asList("0:start:0", "1:start:2", "2:start:3", "2:end:4", "1:end:5", "0:end:6")))); // 3, 2, 2
        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions_636().exclusiveTime(2,
                asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")))); // 3, 4
        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions_636().exclusiveTime(1,
                asList("0:start:0", "0:end:6")))); //7
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];

        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] split = log.split(":");
            int fun = Integer.parseInt(split[0]);
            String action = split[1];
            int ts = Integer.parseInt(split[2]);

            if (!stack.isEmpty()) {
                Integer prev = stack.peek();
                time[prev] += ts - prevTime;
            }

            prevTime = ts;

            if ("start".equals(action)) {
                stack.push(fun);
            } else {
                int prev = stack.pop();
                time[prev]++;
                prevTime++;
            }
        }

        return time;
    }
}
