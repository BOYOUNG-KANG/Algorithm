import java.util.*;

class Solution {
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = 400_000_000_000_000L;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canmove(a, b, g, s, w, t, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean canmove(int a, int b, int[] g, int[] s, 
                            int[] w, int[] t, long time){
        long gold = 0;
        long silver = 0;
        long total = 0;
        
        for (int i = 0; i < g.length; i++) {
            //운반횟수 구하기
            long count = time / ((long) 2 * t[i]); 
            if (time % ((long) 2 * t[i]) >= t[i]) {
                count++;
            }
            
            long move = count * w[i];
            
            gold += Math.min(move, g[i]);
            silver += Math.min(move, s[i]);
            total += Math.min(move, (long) g[i] + s[i]);
            
            if (gold >= a && silver >= b && total >= a + b) {
                return true;
            }
        }
        return false;
            
    }
}