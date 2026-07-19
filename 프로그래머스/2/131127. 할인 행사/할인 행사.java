import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int k = 10; // window 길이 10 고정
        Map<String, Integer> map = new HashMap<>();
        
        //1. 첫번째 윈도우 구성
        int left = 0;
        for (int i = left; i < left + k; i++) {
            int cnt = map.getOrDefault(discount[i], 0);
            map.put(discount[i], cnt+1);
        }
        
        //2. 첫번째 윈도우 테스트
        boolean isDiscount = true;
        for (int i = 0; i < want.length; i++) {
            int cnt = map.getOrDefault(want[i], 0);   
            if (cnt != number[i]) {
                isDiscount = false;
                break;
            }
        }
        if (isDiscount) answer++;
        
        //3. 한 칸씩 이동
        for (int right = k; right < discount.length; right++) {
            left++;
            map.put(discount[left-1], map.getOrDefault(discount[left-1], 0)- 1);
            map.put(discount[right], map.getOrDefault(discount[right], 0)+ 1);
            
            isDiscount = true;
            for (int i = 0; i < want.length; i++) {
                int cnt = map.getOrDefault(want[i], 0);   
                if (cnt != number[i]) {
                    isDiscount = false;
                    break;
                }
            }
            if (isDiscount) answer++;
        }
        
        return answer;
    }
}