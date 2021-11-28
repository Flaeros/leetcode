def solve_knapsack(profits, weights, capacity):
    return solve_knapsack_rec(profits, weights, capacity, 0)


def solve_knapsack_rec(profits, weights, capacity, index):
    n = len(profits)
    if capacity <= 0 or n == 0 or len(weights) != n or index >= n:
        return 0

    inclusive = 0
    if weights[index] <= capacity:
        inclusive = profits[index] + solve_knapsack_rec(profits, weights, capacity - weights[index], index)

    exclusive = solve_knapsack_rec(profits, weights, capacity, index + 1)

    return max(inclusive, exclusive)


def main():
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 8))
    print(solve_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 6))


if __name__ == '__main__':
    main()
