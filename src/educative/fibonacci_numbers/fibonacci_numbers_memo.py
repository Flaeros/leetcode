def calculateFibonacci(n):
    memo = [-1 for _ in range(n + 1)]

    return calculateFibonacci_rec(memo, n)


def calculateFibonacci_rec(memo, n):
    if n < 2:
        return n

    if memo[n] == -1:
        memo[n] = calculateFibonacci_rec(memo, n - 1) + calculateFibonacci_rec(memo, n - 2)

    return memo[n]


def main():
    print("0th Fibonacci is ---> " + str(calculateFibonacci(0)))
    print("1th Fibonacci is ---> " + str(calculateFibonacci(1)))
    print("2th Fibonacci is ---> " + str(calculateFibonacci(2)))
    print("3th Fibonacci is ---> " + str(calculateFibonacci(3)))
    print("4th Fibonacci is ---> " + str(calculateFibonacci(4)))
    print("5th Fibonacci is ---> " + str(calculateFibonacci(5)))
    print("6th Fibonacci is ---> " + str(calculateFibonacci(6)))
    print("7th Fibonacci is ---> " + str(calculateFibonacci(7)))


if __name__ == '__main__':
    main()
