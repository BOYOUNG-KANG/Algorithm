import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if (s1.equals("Enter")) {
                String s3 = st.nextToken();
                map.put(s2, s3);
                cnt++;
            } else if (s1.equals("Change")){
                String s3 = st.nextToken();
                map.put(s2, s3);
            } else if (s1.equals("Leave")) {
                cnt++;
            }
        }
        int idx = 0;
        String[] answer = new String[cnt];
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if (s1.equals("Enter")) {
                String nick = map.get(s2);
                answer[idx++] = nick + "님이 들어왔습니다.";
            } else if (s1.equals("Leave")) {
                String nick = map.get(s2);
                answer[idx++] = nick + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}