arr = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
a, b = map(int, input().split())
day = 0

for i in range(a-1):
    day += arr[i]
day += b
print(week[day % 7])