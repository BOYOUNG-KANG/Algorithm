import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer, -1);
        
        for (int i = numbers.length-1; i >= 0; i--) {
            int now = numbers[i];
            
            while(!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            
            stack.push(now);
        }
        return answer;
    }
}