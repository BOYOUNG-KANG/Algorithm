while True:
    n, m = map(int, input().split())
    answer = n + m
    if n == 0 and m == 0:
        break
    else:
        print(answer)