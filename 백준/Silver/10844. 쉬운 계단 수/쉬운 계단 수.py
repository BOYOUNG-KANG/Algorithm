n = int(input())

matrix = [[0] * 10 for _ in range(n+1)]
for i in range(1, 10):
    matrix[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            matrix[i][j] = matrix[i-1][1]
        elif 1 <= j <= 8:
            matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j+1]
        else:
            matrix[i][j] = matrix[i-1][8]

answer = 0
for i in range(10):
    answer += matrix[n][i]
print(answer % 1000000000)