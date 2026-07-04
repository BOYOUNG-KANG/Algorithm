import java.util.*;

class Solution {
    static int[] days;
    public int[] solution(int[] progresses, int[] speeds) {
        
        days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]);
            int day = (remain % speeds[i] > 0) ?
                (remain / speeds[i] + 1) : (remain / speeds[i]);
            
            days[i] = day;
        }
        System.out.println(Arrays.toString(days));
        
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        
        for (int i = 0; i < days.length; i++) {
            if (stack.isEmpty()) {
                stack.push(days[i]);
                answer.add(1);
            } else {
                int prev = stack.peek();
                
                if (prev >= days[i]) {
                    int tmp = answer.get(idx);
                    answer.set(idx, tmp+1);
                } else {
                    stack.push(days[i]);
                    idx++;
                    answer.add(1);
                }
            }
            
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}