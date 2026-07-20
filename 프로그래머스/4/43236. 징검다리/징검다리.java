import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            
            if (can(mid, rocks, n, distance)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    private boolean can(int mid, int[] rocks, int n, int distance) {
        int removed = 0;
        
        int len = rocks[0];
        int prev = 0;
        if (len < mid) {
            removed++;   
        } else {
            prev = rocks[0];
        }
        
        for (int i = 1; i < rocks.length; i++) {
            if (rocks[i] - prev < mid) {
                removed++;   
            } else {
                prev = rocks[i];
            }
        }
        
        if (distance - prev < mid) {
            removed++;   
        }
        
        if (removed > n) return false;
        return true;
    }
    
}