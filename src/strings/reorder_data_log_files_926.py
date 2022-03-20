# extract digit only strings to a list
# extract letter string to a dict
# sort a dict

class Solution:
    def reorderLogFiles(self, logs):
        digital = []
        letters = []

        for log in logs:
            if log.split()[1].isdigit():
                digital.append(log)
            else:
                letters.append(log)

        letters = sorted(letters, key=lambda x: (x.split()[1:], x.split()[0]))

        result = letters + digital

        return result


print(Solution().reorderLogFiles(
    ["27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401",
     "c otdk cl", "8 ksif m u"]))
print(Solution().reorderLogFiles(["dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"]))
