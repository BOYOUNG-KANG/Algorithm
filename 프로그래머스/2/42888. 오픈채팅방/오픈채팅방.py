def solution(record):
    answer = []
    userid = dict()
    n = len(record)
    
    for i in range(n):
        temp = list(record[i].split(" "))
        if temp[0] == 'Enter' or temp[0] == 'Change':
            userid[temp[1]] = temp[2]
    
    for i in range(n):
        temp = list(record[i].split(" "))
        nickname = userid[temp[1]]
        if temp[0] == 'Enter':
            answer.append(nickname + "님이 들어왔습니다.")
        elif temp[0] == 'Leave':
            answer.append(nickname + "님이 나갔습니다.")
    return answer