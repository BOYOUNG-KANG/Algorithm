import sys
INF = sys.maxsize

def solution(friends, gifts):
    answer = 0
    n = len(friends)
    matrix = [[0] * n for _ in range(n)]
    next_matrix = [[0] * n for _ in range(n)]
    
    for i in range(n):
        matrix[i][i] = INF
        
    for gift in gifts:
        g = gift.split(" ")
        for g_idx, giver in enumerate(friends):
            for r_idx, receiver in enumerate(friends):
                if giver == g[0] and receiver == g[1]:
                    matrix[g_idx][r_idx] += 1
     
    grade = [0] * n

 
    for i in range(n):
        for j in range(n):
            grade[i] += matrix[i][j]
            grade[i] -= matrix[j][i]
    
    for i in range(n):
        for j in range(n):
            if i != j:
                if matrix[i][j] < matrix[j][i]:
                    next_matrix[i][j] = 1
                    
                elif matrix[i][j] > matrix[j][i]:
                    next_matrix[j][i] = 1
                else:
                    if grade[i] > grade[j]:
                        
                        next_matrix[j][i] = 1
                    elif grade[i] < grade[j]:
                        
                        next_matrix[i][j] = 1
    
    for i in range(n):
        count = 0
        for j in range(n):
            count += next_matrix[j][i]
        answer = max(answer, count)
    
    return answer