def solution(s):
    answer = 0
    
    first_count = 0
    other_count = 0
        
    for i in range(len(s)):
        if first_count == other_count:
            answer += 1
            k = s[i]
        if k == s[i]:
            first_count += 1
        else:
            other_count += 1
           
    return answer