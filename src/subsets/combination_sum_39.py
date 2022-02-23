class Solution(object):
    def combinationSum(self, candidates, target):
        results = []
        self.combinationSumRec(candidates, results, [], 0, target)
        return results

    def combinationSumRec(self, candidates, results, comb, start, remain):
        if remain < 0:
            return
        elif remain == 0:
            results.append(list(comb))
        else:
            for i in range(start, len(candidates)):
                comb.append(candidates[i])
                self.combinationSumRec(candidates, results, comb, i, remain - candidates[i])
                comb.pop()


print(Solution().combinationSum(candidates=[2, 3, 6, 7], target=7))
print(Solution().combinationSum(candidates=[2, 3, 5], target=8))
print(Solution().combinationSum(candidates=[2], target=1))
