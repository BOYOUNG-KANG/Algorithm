def solution(numbers, hand):
    answer = []
    numbers_dict = {
        '1':(0, 0), '2':(0, 1), '3':(0, 2), 
        '4':(1, 0), '5':(1, 1), '6':(1, 2), 
        '7':(2, 0), '8':(2, 1), '9':(2, 2), 
        '*':(3, 0), '0':(3, 1), '#':(3, 2), 
    }
    left_loc = numbers_dict['*']
    right_loc = numbers_dict['#']
    
    for i in range(len(numbers)):
        if numbers[i] == 1 or numbers[i] == 4 or numbers[i] == 7:
            print(numbers[i])
            answer.append("L")
            left_loc = numbers_dict[str(numbers[i])]
        elif numbers[i] == 3 or numbers[i] == 6 or numbers[i] == 9:
            print(numbers[i])
            answer.append("R")
            right_loc = numbers_dict[str(numbers[i])]
        else: #2, 5, 8, 0
            left_direct = 0
            right_direct = 0
            left_direct = abs(left_loc[0] - numbers_dict[str(numbers[i])][0]) + abs(left_loc[1] - numbers_dict[str(numbers[i])][1])
            right_direct = abs(right_loc[0] - numbers_dict[str(numbers[i])][0]) + abs(right_loc[1] - numbers_dict[str(numbers[i])][1])

            if left_direct < right_direct:
                answer.append("L")
                left_loc = numbers_dict[str(numbers[i])]
            elif left_direct > right_direct:
                answer.append("R")
                right_loc = numbers_dict[str(numbers[i])]
            else:
                if hand[0] == "l":
                    answer.append("L")
                    left_loc = numbers_dict[str(numbers[i])]
                else:
                    answer.append("R")
                    right_loc = numbers_dict[str(numbers[i])]

    answer = ''.join(answer)
            
    return answer