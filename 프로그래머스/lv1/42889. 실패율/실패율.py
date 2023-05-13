from collections import defaultdict

def solution(N, stages):
    remain = len(stages)
    stage_dict =  defaultdict(int)
    for elem in stages:
        stage_dict[elem] += 1

    stage_per_fail = [0] * N
    
    for i in range(N):
        temp_success_count = remain - stage_dict[i + 1]
        temp_challenge_count = remain
        remain = temp_success_count
    
        if temp_challenge_count == 0:
            stage_per_fail[i] = 0
            continue
        stage_per_fail[i] = 1 - (temp_success_count / temp_challenge_count)

    index_and_fail = list(enumerate(stage_per_fail))
    index_and_fail.sort(key=lambda x: -x[1])

    answer = [val[0] + 1 for val in index_and_fail]
    return answer