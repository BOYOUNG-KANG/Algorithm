before, after = map(int, input().split())

count = 1
while (before != after):
    pre_val = after
    if after % 10 == 1:
        after //= 10
        count += 1
    elif after % 2 == 0:
        after //= 2
        count += 1

    if pre_val == after:
        print(-1)
        break
else:
    print(count)