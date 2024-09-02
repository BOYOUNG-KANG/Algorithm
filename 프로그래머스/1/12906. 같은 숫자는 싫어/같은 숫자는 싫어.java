import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        int count = 0;

        Stack<Integer> stack = new Stack<>();
        for (int ele : arr) {
            if (!stack.isEmpty()){
                int tmp = stack.peek();
                if (tmp != ele) {
                    stack.push(ele);
                    count++;
                }
            } else {
                stack.push(ele);
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = count-1;
        while (!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }
        return answer;
    }
}