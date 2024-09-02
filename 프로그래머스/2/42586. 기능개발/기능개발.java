import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] remains = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (day * speeds[i] < remain) day++;
            remains[i] = day;
        }

        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < remains.length; i++) {
            if (remains[i] > max) {
                if (count > 0) {
                    list.add(count);
                }
                max = remains[i];
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}