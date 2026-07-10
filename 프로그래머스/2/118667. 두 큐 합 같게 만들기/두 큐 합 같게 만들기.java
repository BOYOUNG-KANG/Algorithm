import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1cnt = 0;
        long q2cnt = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1cnt += queue1[i];
            q1.offer(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            q2cnt += queue2[i];
            q2.offer(queue2[i]);
        }
        
        while (q1cnt != q2cnt) {
            if (q1.isEmpty() || q2.isEmpty() || answer > queue1.length * 3) { // 큐 넣었다뺐다하는 작업 횟수에 제한 두어 시간 초과 방지
                return -1;
            }
            
            if (q1cnt > q2cnt) {
                int tmp = q1.poll();
                q2.offer(tmp);
                q1cnt -= tmp;
                q2cnt += tmp;
                answer++;
            } else if (q1cnt < q2cnt) {
                int tmp = q2.poll();
                q1.offer(tmp);
                q2cnt -= tmp;
                q1cnt += tmp;
                answer++;
            }
        }
        
        return answer;
    }
}