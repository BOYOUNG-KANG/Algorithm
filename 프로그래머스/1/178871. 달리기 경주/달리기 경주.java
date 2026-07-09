import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String now = callings[i];
            int idx = map.get(now);
            String prev = players[idx-1];
            // 순서 바꾸기
            players[idx-1] = now;
            players[idx] = prev;
            
            map.put(now, idx-1);
            map.put(prev, idx);
        }
        return players;
    }
}