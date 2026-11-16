import java.util.*;

class Solution
{
    public int solution(String s)
    {
        if (s.length() % 2 != 0) return 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char prev = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == prev) {
                stack.pop();
            } else {
                stack.push(prev);
            }
        }
        
        if (stack.size() > 0)return 0;
        return 1;
    }
}