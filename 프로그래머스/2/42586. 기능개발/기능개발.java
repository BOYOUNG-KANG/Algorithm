import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int tmp = (100 - progresses[i]) / speeds[i];
            if (progresses[i] + tmp * speeds[i] < 100) {
                tmp += 1;
            } 
            days[i] = tmp;
        }
        
        int max = days[0];
        int cnt  = 1;
        for (int i = 1; i < progresses.length; i++) {
            if (max >= days[i]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                max = days[i];
            }
        }
        list.add(cnt);
        
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}