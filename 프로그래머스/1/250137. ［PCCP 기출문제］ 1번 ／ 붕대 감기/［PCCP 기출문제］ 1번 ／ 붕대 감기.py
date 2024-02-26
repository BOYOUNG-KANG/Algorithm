def solution(bandage, health, attacks):
    
    attacks_dict = dict()
    
    for attack in attacks:
        attacks_dict[attack[0]] = attack[1]
    
    t = 0
    continue_t = 0
    max_time = attacks[-1][0]
    now_h = health
    
    while t <= max_time:
        
        if t in attacks_dict:
            now_h -= attacks_dict[t]
            continue_t = 0
            if now_h <= 0:
                return -1
        else:
            now_h += bandage[1]
            continue_t += 1
                
            if continue_t == bandage[0]:
                now_h += bandage[2]
                continue_t = 0
            
            if now_h > health:
                now_h = health
        t += 1
    
    return now_h