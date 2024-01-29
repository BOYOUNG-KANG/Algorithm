def sol(change):
    coin_unit = [25, 10, 5, 1]
    coins = [0] * 4
    
    for i in range(len(coin_unit)):
        a = change // coin_unit[i]
        coins[i] = a
        change = change - a * coin_unit[i]
    for coin in coins:
        print(coin, end=" ")

n = int(input())
inputs = []
for i in range(n):
    inputs.append(int(input()))
for i in inputs:
    sol(i)