import java.util.*;

class Solution {
    LinkedList<String> cache = new LinkedList<>();
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // cache size 0 인 경우 예외처리
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            boolean isHit = false;
            for (String ele : cache) {
                ele = ele.toUpperCase();
                if (ele.equals(city)) { //hit
                    isHit = true;
                    break;
                } 
            }
            
            if (isHit) {
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.poll();
                    cache.offer(city);
                    answer += 5;
                } else {
                    cache.offer(city);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}