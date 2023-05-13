def solution(n, arr1, arr2):
    first_map = [[] for _ in range(n)]
    second_map = [[] for _ in range(n)]
    final_map = [[] for _ in range(n)]

    for i in range(n):
        temp = bin(arr1[i])
        temp_first = list(temp[2:])
        remain = n - len(temp_first)
        if remain > 0:
            for j in range(remain):
                first_map[i].insert(0, '0')
        first_map[i].extend(temp_first)
        
        temp2 = bin(arr2[i])
        temp_second = list(temp2[2:])
        remain2 = n - len(temp_second)
        if remain2 > 0:
            for k in range(remain2):
                second_map[i].insert(0, '0')
        second_map[i].extend(temp_second)

        for final in range(n):
            if first_map[i][final] == '1' or second_map[i][final] == '1':
                final_map[i].append('#')
            else:
                final_map[i].append(' ')
        final_map[i] = ''.join(final_map[i])
    
    return final_map