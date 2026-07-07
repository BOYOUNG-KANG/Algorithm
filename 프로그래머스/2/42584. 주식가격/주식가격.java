import java.util.*;

class Solution {
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        //완탐하면 타임아웃 걸리는 문제. 
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            answer[tmp] = prices.length - tmp - 1;
        }
        
        return answer;
    }
}