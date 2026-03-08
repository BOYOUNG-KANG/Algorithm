import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 가장먼저 탈락한 사람, 몇번째에서 탈락하는지
        Set<String> before = new HashSet<>();
        char last = '*';
        for (int i = 0; i < words.length; i++) {
            int b = before.size();
            before.add(words[i]);
            int a = before.size();
            
            if ((last != '*' && last != words[i].charAt(0)) || a == b) {
                answer[0] =  (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            last = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}