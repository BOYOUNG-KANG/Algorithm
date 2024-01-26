n, k = map(int, input().split())
coins = []
for i in range(n):
    coins.append(int(input()))

coins.sort()

count = 0
for coin in coins[::-1]:
    a = k // coin
    k -= a * coin
    count += a
print(count)