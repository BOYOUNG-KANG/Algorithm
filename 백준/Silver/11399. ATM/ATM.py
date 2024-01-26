n = int(input())
m = list(map(int, input().split()))
m.sort()

import sys
INF = sys.maxsize

d = [INF] * n
d[0] = m[0]

for i in range(n):
    d[i] = min(d[i], d[i-1] + m[i])

min_val = 0
for i in range(n):
    min_val += d[i]
    
print(min_val)