import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        for (Map.Entry<String, Integer> entry: list) {
        	int[][] top = new int[2][2]; top[0][0] = -1; top[0][1] = -1;
        	for (int i = 0; i < genres.length; i++) {
        		if (entry.getKey().equals(genres[i])) {
        			if (top[1][0] < plays[i]) {
        				if (top[0][0] < plays[i]) {
        					top[1][0] = top[0][0]; top[1][1] = top[0][1];
        					top[0][0] = plays[i]; top[0][1] = i;
        				} else {
        					top[1][0] = plays[i]; top[1][1] = i;
        				}
        			}
        		}
        	}
        	answerList.add(top[0][1]);
            if (top[1][0] != -1) {
                answerList.add(top[1][1]);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}