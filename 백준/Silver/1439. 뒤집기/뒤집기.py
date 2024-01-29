s = input()
count = 0

str_count  = [0, 0]
temp = int(s[0])
str_count[temp] = 1
def check(s):
    for i in range(len(s)):
        if s[i-1] != s[i]:
            temp = int(s[i])
            str_count[temp] += 1
            
    if str_count[0] > str_count[1]:
        print(str_count[1])
    elif str_count[0] < str_count[1]:
        print(str_count[0])
    else:
        print(str_count[0])
check(s)        