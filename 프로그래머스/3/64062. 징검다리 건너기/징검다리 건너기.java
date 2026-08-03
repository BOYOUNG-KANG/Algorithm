import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int right = 0;
        int left = 0;
        for (int i = 0; i < stones.length; i++) {
            right = Math.max(right, stones[i]);
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if(can(mid, stones.clone(), k)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    private boolean can(int mid, int[] stones, int k){
        int cnt = 0;
        for (int j = 0; j < stones.length; j++) {
            
            if (stones[j] - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if (cnt >= k) {
                return false;
            }
        }
        return true;
    }
}