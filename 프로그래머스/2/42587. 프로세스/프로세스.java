import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {
        // 일단 queue에 다 넣기
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        int count = 0;
        
        // queue.peek() 한 값이 전체 실행 대기 큐 값들 중 제일 큰 값인지 확인
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            boolean isHigh = false;
            int maxV;

            for (int[] ele : queue) {
                if (ele[1] > now[1]) {
                    isHigh = true;
                    break;
                }
            }

            if (isHigh) {
                queue.offer(now);
            } else {
                count++;
                if (now[0] == location) {
                    return count;
                }
            }
        }
        return count;
    }
}