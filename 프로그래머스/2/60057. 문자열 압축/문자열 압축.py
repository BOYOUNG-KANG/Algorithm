def solution(s):
    min_length = len(s)

    for i in range(1, len(s) // 2 + 1):
        s_list = []
        count = 1  # 중복된 문자열의 개수를 세기 위한 변수
        compressed = ""

        for j in range(0, len(s), i):
            current = s[j:j+i]
            next_str = s[j+i:j+i+i]

            if current == next_str:  # 현재 문자열과 다음 문자열이 같으면 count 증가
                count += 1
            else:
                # 다음 문자열과 다를 때
                if count > 1:
                    compressed += str(count) + current
                else:
                    compressed += current

                count = 1

        now_length = len(compressed)
        min_length = min(min_length, now_length)

    return min_length
