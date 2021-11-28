def solve_knapsack(profits, weights, capacity):
    dp = [[-1 for x in range(capacity + 1)] for y in range(len(profits))]
    return solve_knapsack_rec(profits, weights, capacity, 0, dp)


def solve_knapsack_rec(profits, weights, capacity, index, dp):
    n = len(profits)
    if capacity <= 0 or n == 0 or len(weights) != n or index >= n:
        return 0

    if dp[index][capacity] == -1:
        inclusive = 0
        if weights[index] <= capacity:
            inclusive = profits[index] + solve_knapsack_rec(profits, weights, capacity - weights[index], index, dp)

        exclusive = solve_knapsack_rec(profits, weights, capacity, index + 1, dp)

        dp[index][capacity] = max(inclusive, exclusive)

    return dp[index][capacity]


def main():
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 8))
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 6))


if __name__ == '__main__':
    main()
