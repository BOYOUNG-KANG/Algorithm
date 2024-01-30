n, l  = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = 1
temp_l = l - 1
for i in range(1, len(arr)):
    r = arr[i] - arr[i - 1]
    if temp_l < r:
        answer += 1
        temp_l = l - 1
    else:
        temp_l -= r
    
print(answer)