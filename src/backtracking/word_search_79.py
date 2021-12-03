# loop all board
# find first char
# dfs the rest of them
# store visited
# return true if found the last one

class Solution(object):
    def exist(self, board, word):
        n = len(board)
        m = len(board[0])

        visited = [[False for _ in range(m)] for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    if self.dfs(board, word, i, j, 0, visited):
                        return True

        return False

    def dfs(self, board, word, i, j, index, visited):
        if i >= len(board) or i < 0 or j >= len(board[0]) or j < 0:
            return False

        if board[i][j] != word[index] or visited[i][j] :
            return False

        if index == len(word) - 1:
            return True

        visited[i][j] = True

        if self.dfs(board, word, i - 1, j, index + 1, visited) or \
                self.dfs(board, word, i, j + 1, index + 1, visited) or \
                self.dfs(board, word, i + 1, j, index + 1, visited) or \
                self.dfs(board, word, i, j - 1, index + 1, visited):
            return True

        visited[i][j] = False

        return False


print(Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED"))
print(Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="SEE"))
print(Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB"))
