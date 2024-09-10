import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
        	if (target.equals(words[i])) {
        		flag = true;
        	}
        }
        
        if (flag == false) {
        	return 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        
		for (int j = 0; j < words.length; j++) {
			char[] wordArr = words[j].toCharArray();
			char[] beginArr = begin.toCharArray();
			int count = 0;
			for (int k = 0; k < wordArr.length; k++) {
				if (wordArr[k]!= beginArr[k]) {
					count++;
				}
			}
			
			if (count == 1) {
				visited[j] = true;
				q.add(new int[] {j, 1});
			}
		}
		
		while (!q.isEmpty()) {
			
			int[] temp = q.poll();
			int cnt = temp[1];
			begin = words[temp[0]];
			
			
			if (begin.equals(target)) {
				return cnt;
			}
			for (int j = 0; j < words.length; j++) {
				char[] wordArr = words[j].toCharArray();
    			char[] beginArr = begin.toCharArray();
    			int count = 0;
    			for (int k = 0; k < wordArr.length; k++) {
    				if (wordArr[k] != beginArr[k]) {
    					count++;
    				}
    			}
    			if (!visited[j] &&count == 1) {
    				visited[j] = true;
    				q.add(new int[] {j, cnt+1});
    				
    			}
			}
			
		}
    	return answer;
	
    }
}