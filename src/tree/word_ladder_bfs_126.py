from collections import defaultdict, deque


def oneCharDifference(prev, next):
    if len(prev) != len(next):
        return False
    difference = 0
    for i in range(len(prev)):
        if prev[i] != next[i]:
            difference += 1

    return difference == 1


class Solution:
    def ladderLengthAdj(self, start, end, words):
        if end not in words:
            return False

        adjacency = defaultdict(set)

        words.append(start)

        for prev in words:
            for next in words:
                if prev == next:
                    continue

                if oneCharDifference(prev, next):
                    adjacency[prev].add(next)
                    adjacency[next].add(prev)

        visited = set()

        queue = deque([(start, 1)])

        while queue:
            word, length = queue.pop()

            if end in adjacency[word]:
                return length + 1

            visited.add(word)

            for next in adjacency[word]:
                if next not in visited:
                    queue.appendleft((next, length + 1))

        return 0

    def ladderLength(self, start, end, words):
        words = set(words)
        queue = deque([[start, 1]])
        while queue:
            word, length = queue.popleft()
            if word == end:
                return length
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i + 1:]
                    if next_word in words:
                        words.remove(next_word)
                        queue.append([next_word, length + 1])
        return 0


print(Solution().ladderLength("hit",
                              "cog",
                              ["hot", "dot", "dog", "lot", "log"]))

print(Solution().ladderLength(start="hit",
                              end="cog",
                              words=["hix", "dog", "log", "hot", "dot", "lot"]))

print(Solution().ladderLengthAdj("hit",
                                 "cog",
                                 ["hot", "dot", "dog", "lot", "log"]))

print(Solution().ladderLengthAdj(start="hit",
                                 end="cog",
                                 words=["hix", "dog", "log", "hot", "dot", "lot"]))

# "hit" -> "hot" -> "dot" -> "dog" -> cog"
