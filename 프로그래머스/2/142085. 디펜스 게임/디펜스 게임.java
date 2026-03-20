import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //가장 큰 enemy 기준 정렬
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];
            
            if (n < 0) {
                if (k > 0) {
                    int tmp = pq.poll();
                    n += tmp;
                    k -= 1;
                } else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
    
}