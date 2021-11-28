def solve_knapsack(profits, weights, capacity):
    dp = [[-1 for x in range(capacity + 1)] for y in range(len(profits))]
    return solve_knapsack_rec(dp, profits, weights, capacity, 0)


def solve_knapsack_rec(dp, profits, weights, capacity, current_index):
    if capacity <= 0 or current_index >= len(profits):
        return 0

    if dp[current_index][capacity] > -1:
        return dp[current_index][capacity]

    profit1 = 0
    if weights[current_index] <= capacity:
        profit1 = profits[current_index] \
                  + solve_knapsack_rec(dp, profits, weights, capacity - weights[current_index], current_index + 1)

    profit2 = solve_knapsack_rec(dp, profits, weights, capacity, current_index + 1)

    max_profit = max(profit1, profit2)
    dp[current_index][capacity] = max_profit
    return max_profit


def main():
    print(solve_knapsack([1, 6, 10, 16], [1, 2, 3, 5], 7))
    print(solve_knapsack([1, 6, 10, 16], [1, 2, 3, 5], 6))


if __name__ == '__main__':
    main()
