def solve_knapsack(profits, weights, capacity):
    n = len(profits)

    if capacity <= 0 or n <= 0 or len(weights) != n:
        return 0

    dp = [[0 for x in range(capacity + 1)] for y in range(n)]

    # if we have only one weight, we will take it if it is not more than the capacity
    for c in range(0, capacity + 1):
        if weights[0] <= c:
            dp[0][c] = profits[0]

    for i in range(1, n):
        for c in range(1, capacity + 1):
            profit1, profit2 = 0, 0
            if weights[i] <= c:
                profit1 = profits[i] + dp[i - 1][c - weights[i]]
            profit2 = dp[i - 1][c]

            dp[i][c] = max(profit1, profit2)

    print_selected_elements(dp, profits, weights, capacity)

    return dp[n - 1][capacity]


def print_selected_elements(dp, profits, weights, capacity):
    elemens = []
    n = len(weights)
    total = dp[n - 1][capacity]

    for i in range(n, 0, -1):
        if total != dp[i-1][capacity]:
            elemens.append(weights[i])
            capacity -= weights[i]
            total -= profits[i]

    print(elemens)


def main():
    print(solve_knapsack([1, 6, 10, 16], [1, 2, 3, 5], 7))
    print(solve_knapsack([1, 6, 10, 16], [1, 2, 3, 5], 6))


if __name__ == '__main__':
    main()
