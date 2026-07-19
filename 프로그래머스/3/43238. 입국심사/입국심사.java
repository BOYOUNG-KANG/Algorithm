import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for (int t : times) {
            max = Math.max(max, t);
        }
        
        long left = 0;
        long right = max * n;
        long answer = right;
        while (left <= right) {
            long mid = (right + left) / 2;
            
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }
            
            if (sum >= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else if (sum < n) {
                left = mid + 1;
            } 
        }
        return answer;
    }
}