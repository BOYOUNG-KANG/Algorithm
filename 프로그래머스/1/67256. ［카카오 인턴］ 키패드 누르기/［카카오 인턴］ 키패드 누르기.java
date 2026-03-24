import java.util.*;

class Solution {
    Map<Integer, int[]> pad;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        pad = new HashMap<>();
        
        // 키패드 세팅
        int y = 0; int x = -1;
        for (int i = 1; i < 10; i++) {
            if (x >= 2) {
                x = -1;
                y++;
            }
            x++;
            pad.put(i, new int[]{y, x});
        }
        pad.put(0, new int[]{3, 1});
        
        // 처음 세팅: 왼손 *, 오른손 #
        int[] l = new int[]{3, 0}; 
        int[] r = new int[]{3, 2}; 
        for (int i = 0; i < numbers.length; i++) {
            if ( numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) { //왼손 사용
                int[] val = pad.get(numbers[i]);
                l[0] = val[0];
                l[1] = val[1];
                answer += "L";
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){ //오 사용
                int[] val = pad.get(numbers[i]);
                r[0] = val[0];
                r[1] = val[1];
                answer += "R";
            } else { //더 가까운 손 이동
                //둘 중에 가까운 손 확인
                int[] next = pad.get(numbers[i]);
                long lv = Math.abs(next[0] - l[0]) + Math.abs(next[1] - l[1]);
                long rv = Math.abs(next[0] - r[0]) + Math.abs(next[1] - r[1]);
                
                if (lv < rv) {
                    l[0] = next[0];
                    l[1] = next[1];
                    answer += "L";
                } else if (lv > rv) {
                    r[0] = next[0];
                    r[1] = next[1];
                    answer += "R";
                } else {  // 길이 동일 시, hand 값 확인   
                    if (hand.equals("left")) {
                        l[0] = next[0];
                        l[1] = next[1];
                        answer += "L";
                    } else {
                        r[0] = next[0];
                        r[1] = next[1];
                        answer += "R";
                    }
                }
            }
        }
        
        return answer;
    }
}