def calculateFibonacci(n):
    prev = 0
    next = 1

    for i in range(n - 1):
        temp = next
        next = prev + next
        prev = temp

    return next


def main():
    print("5th Fibonacci is ---> " + str(calculateFibonacci(5)))
    print("6th Fibonacci is ---> " + str(calculateFibonacci(6)))
    print("7th Fibonacci is ---> " + str(calculateFibonacci(7)))


if __name__ == '__main__':
    main()
