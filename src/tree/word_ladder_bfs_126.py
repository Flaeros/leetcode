from collections import defaultdict, deque


def oneCharDifference(prev, next):
    if len(prev) != len(next):
        return False
    difference = 0
    for i in range(len(prev)):
        if prev[i] != next[i]:
            difference += 1

    return difference == 1


def canBeTransformed(start, end, words):
    adjacency = defaultdict(set)

    words.append(end)
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


print(canBeTransformed(start="hit",
                       end="cog",
                       words=["hix", "dog", "log", "hot", "dot", "lot"]))

# "hit" -> "hot" -> "dot" -> "dog" -> cog"
