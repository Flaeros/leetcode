def solve_knapsack(profits, weights, capacity):
    n = len(profits)

    if capacity <= 0 or n == 0 or len(weights) != n:
        return 0

    dp = [[-1 for x in range(capacity + 1)] for y in range(len(profits))]

    for i in range(n):
        dp[i][0] = 0

    for i in range(n):
        for j in range(1, capacity + 1):
            inclusive, exclusive = 0, 0
            if weights[i] <= j:
                inclusive = profits[i] + dp[i][j - weights[i]]

            if i > 0:
                exclusive = dp[i-1][j]

            dp[i][j] = max(inclusive, exclusive)

    return dp[n - 1][capacity]


def main():
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 8))
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 6))


if __name__ == '__main__':
    main()
