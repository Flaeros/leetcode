class Solution(object):
    def combinationSum2(self, candidates, target):
        candidates.sort()
        results = []
        self.combinationSum2Rec(candidates, results, [], 0, target)
        return results

    def combinationSum2Rec(self, candidates, results, comb, start, remain):
        if remain < 0:
            return
        elif remain == 0:
            results.append(list(comb))
        else:
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]:
                    continue

                comb.append(candidates[i])
                self.combinationSum2Rec(candidates, results, comb, i + 1, remain-candidates[i])
                comb.pop()


print(Solution().combinationSum2(candidates=[10, 1, 2, 7, 6, 1, 5], target=8))
print(Solution().combinationSum2(candidates=[2, 5, 2, 1, 2], target=5))
