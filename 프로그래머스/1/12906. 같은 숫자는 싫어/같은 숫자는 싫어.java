import java.util.*;

public class Solution {
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public int[] solution(int []arr) {
        
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                int prev = stack.peek();
                if (prev != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }
        int[] answer = new int[stack.size()];
        
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}