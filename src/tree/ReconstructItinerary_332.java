package tree;

import java.util.*;

import static java.util.Arrays.asList;

public class ReconstructItinerary_332 {

    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary_332().findItinerary(asList(
                asList("MUC", "LHR"), asList("JFK", "MUC"), asList("SFO", "SJC"), asList("LHR", "SFO"))));
        System.out.println(new ReconstructItinerary_332().findItinerary(asList(
                asList("JFK", "SFO"), asList("JFK", "ATL"), asList("SFO", "ATL"), asList("ATL", "JFK"), asList("ATL", "SFO"))));
        System.out.println(new ReconstructItinerary_332().findItinerary2(asList(
                asList("MUC", "LHR"), asList("JFK", "MUC"), asList("SFO", "SJC"), asList("LHR", "SFO"))));
        System.out.println(new ReconstructItinerary_332().findItinerary2(asList(
                asList("JFK", "SFO"), asList("JFK", "ATL"), asList("SFO", "ATL"), asList("ATL", "JFK"), asList("ATL", "SFO"))));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        List<String> route = new LinkedList<>();
        Map<String, PriorityQueue<String>> flights = new HashMap<>();

        for (List<String> ticket : tickets) {
            PriorityQueue<String> queue = flights.getOrDefault(ticket.get(0), new PriorityQueue<>());
            queue.add(ticket.get(1));
            flights.put(ticket.get(0), queue);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            while (flights.containsKey(current) && !flights.get(current).isEmpty()) {
                PriorityQueue<String> queue = flights.get(current);
                String next = queue.poll();
                stack.push(next);
                current = stack.peek();
            }
            route.add(0, stack.pop());
        }

        return route;
    }
}
