def solution(board, moves):
    removed_count = 0
    basket = []
    pre_pick = 0
    now_pick = 0
    
    for i in range(len(moves)):
        temp = moves[i] - 1
        for j in range(len(board)):
            if board[j][temp] > 0:
                basket.append(board[j][temp])
                board[j][temp] = 0
                if len(basket) >= 2 and basket[-1] == basket[-2]:
                    removed_count += 2
                    basket.pop()
                    basket.pop()
                now_pick = 0
                break  
    
    return removed_count