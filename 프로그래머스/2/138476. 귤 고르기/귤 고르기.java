import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int tmp = map.getOrDefault(tangerine[i], 0);
            map.put(tangerine[i], tmp+1);
        }
        
        int[] arr = new int[map.values().size()];
        int idx = 0;
        for (int e : map.values()) {
            arr[idx++] = e;
        }
    
        Arrays.sort(arr);
        for (int i = arr.length-1; i >= 0; i--) {
            if (k <= 0) break;
            k-= arr[i];
            answer++;
        }
        
        return answer;
    }
}