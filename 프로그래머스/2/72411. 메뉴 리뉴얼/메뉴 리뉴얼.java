import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static Map<Integer, Integer> maxMap;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        maxMap = new HashMap<>();
        
        // 1. course에 각 숫자만큼 orders[i]를 조합한 경우의 수를 map에 넣는다.
        // 2. map<조합, 주문갯수> 을 업데이트한다.
        // 3. 각 조합 갯수별 가장 많은 주문을 받은 경우만 return
        // (이때 가장많은 주문 최소조건 map.get() >= 2)
        
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            order = new String(arr);
            
            for (int c : course) {
                combi(order, c, "", 0);
            }
        } 
        
        for (Map.Entry<String, Integer> ele : map.entrySet()) {
            String key = ele.getKey();
            int val = ele.getValue();
            int len = key.length();
            
            if (val == maxMap.getOrDefault(len, 0) && val >= 2) {
                answer.add(key);
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    public void combi(String order, int c, String val, int tmp){
        if (val.length() == c) {
            int t = map.getOrDefault(val, 0);
            map.put(val, t + 1);
            
            int max = maxMap.getOrDefault(c, 0);
            maxMap.put(c, Math.max(max, t + 1));
            return;
        }
        
        for (int i = tmp; i < order.length(); i++) {
            combi(order, c, val + order.charAt(i), i+1);
        }
    }
}