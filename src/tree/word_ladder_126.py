# 1 how to get the next proper word
# 2 there can be a few words to get

# 1 find a next word
# 2 make it as used
# 3 continue until we get the end word
# time = N*N*K  K= len(longest_word)
# time = O (KN^N)

# current_word
# words word1
# words - current_word

def canBeTransformed(start, end, words):
    next_words = findTheNextWord(start, words)

    if end in findTheNextWord(start, [end]):
        return True

    if not next_words:
        return False

    for next_word in next_words:
        if len(next_word) != len(end):
            continue

        del words[words.index(next_word)]
        result = canBeTransformed(next_word, end, words)
        if result:
            return True

        words.append(next_word)

    return False


def findTheNextWord(prev_word, words):
    result = []

    for word in words:

        different_chars = 0
        for i in range(len(word)):
            if prev_word[i] != word[i]:
                different_chars += 1

        if different_chars == 1:
            result.append(word)

    return result


print(canBeTransformed(start="hit",
                       end="cog",
                       words=["hix", "dog", "log", "hot", "dot", "lot"]))

# "hit" -> "hot" -> "dot" -> "dog" -> cog"
