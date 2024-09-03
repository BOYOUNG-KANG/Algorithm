import java.util.*;

class Solution {
    static String[] alpa = {"A", "E", "I", "O", "U"};
    static List<String> temp;
    
    public static int solution(String word) {
        temp = new ArrayList<>();
        dfs("", 0);
        int count = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(word)) {
                count = i;
            }
        }
        return count;
    }
    private static void dfs(String w, int len) {
        temp.add(w);
        if (len == 5) return;
        for (int i = 0; i < alpa.length; i++) {
            dfs(w+alpa[i], len+1);
        }
    }
}