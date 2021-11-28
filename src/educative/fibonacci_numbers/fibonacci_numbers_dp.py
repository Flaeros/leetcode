def calculateFibonacci(n):
    dp = [-1 for _ in range(n+1)]

    dp[0] = 0
    dp[1] = 1

    for i in range(2, n+1):
        dp[i] = dp[i-2] + dp[i-1]

    return dp[n]


def main():
    print("5th Fibonacci is ---> " + str(calculateFibonacci(5)))
    print("6th Fibonacci is ---> " + str(calculateFibonacci(6)))
    print("7th Fibonacci is ---> " + str(calculateFibonacci(7)))


if __name__ == '__main__':
    main()
