import java.util.*;

class Solution {
    public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		Arrays.sort(scoville);
		for (int i = 0; i < scoville.length; i++) {
			q.add(scoville[i]);
		}
        int answer = 0;
        while (q.peek() < K && q.size() >= 2) {
        	int a = q.poll();
        	int b = q.poll();
        	int tmp = a + (b * 2);
        	q.add(tmp);
        	answer++;
        }
        
        if (q.peek() < K) {
        	answer = -1;
        }
        return answer;
    }
}