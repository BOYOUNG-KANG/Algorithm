def solution(numbers):
    not_find = [0] * 10
    answer = 0
    for i in range(len(numbers)):
        not_find[numbers[i]] += 1
        
    for j in range(len(not_find)):
        if not_find[j] == 0:
            answer += j
    
    return answer