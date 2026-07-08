import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i < s.length(); i++) {
            String word = "";
            int idx = 0;
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            
            while (idx < s.length()) {
                if (word.isEmpty()) {
                    word = s.substring(idx, Math.min(idx + i, s.length()));
                    cnt = 1;
                } else { // 압축 가능 여부 체크
                    String now = s.substring(idx, Math.min(idx + i, s.length()));
                    
                    if (word.equals(now)) { // 압축 가능
                        cnt++;
                        
                    } else { // 압축 불가능
                        String tmp = (cnt > 1) ? (String.valueOf(cnt) + word) : word;
                        sb.append(tmp);
                        word = now;
                        cnt = 1;
                    }
                }
                idx += i;
            }
            
            String tmp = (cnt > 1) ? (String.valueOf(cnt) + word) : word;
            sb.append(tmp);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}