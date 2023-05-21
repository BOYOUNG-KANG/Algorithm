def solution(left, right):
    answer = 0
    
    for i in range(left, right + 1):
        count = 0
        index = 1
        while index <= i:
            if i % index == 0:
                count += 1
            index += 1
        if count % 2 == 0:
            answer += i
        else:
            answer -= i
            
    return answer