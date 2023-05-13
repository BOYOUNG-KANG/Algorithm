def solution(dartResult):
    answer = 0
    score = [0] * 3
    idx = 0
    
    for i in range(len(dartResult)):
        if dartResult[i].isdigit():
            digit = int(dartResult[i])
            if digit == 1:
                if dartResult[i + 1] == "0":
                    score[idx] = 10
                    idx += 1
                    continue
            if digit == 0:
                if i >= 1 and dartResult[i - 1] == "1":
                    continue
            score[idx] = int(dartResult[i])
            idx += 1
        elif dartResult[i] == "S":
            pass
        elif dartResult[i] == "D":
            score[idx - 1] = score[idx - 1] * score[idx - 1]
        elif dartResult[i] == "T":
            score[idx - 1] = score[idx - 1] * score[idx - 1] * score[idx - 1]
        elif dartResult[i] == "*":
            if idx != 1:
                score[idx - 2] = score[idx - 2] * 2 
            score[idx - 1] = score[idx - 1] * 2
        elif dartResult[i] == "#":
            score[idx - 1] = score[idx - 1] * (-1)

    for i in range(len(score)):
        answer += score[i]
    
    return answer