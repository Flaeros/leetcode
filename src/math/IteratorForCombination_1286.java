package math;

import java.util.PriorityQueue;

public class IteratorForCombination_1286 {
    public static void main(String[] args) {

        CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }

    public static class CombinationIterator {
        PriorityQueue<String> q = new PriorityQueue<>();

        public CombinationIterator(String characters, int combinationLength) {
            generateSubseq(characters, combinationLength, 0, new StringBuilder());
        }

        private void generateSubseq(String characters, int combinationLength, int start, StringBuilder sb) {
            if (combinationLength == 0) {
                q.add(sb.toString());
                return;
            }


            for (int i = start; i <= characters.length() - combinationLength; i++) {
                sb.append(characters.charAt(i));
                generateSubseq(characters, combinationLength - 1, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public String next() {
            return q.poll();
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
