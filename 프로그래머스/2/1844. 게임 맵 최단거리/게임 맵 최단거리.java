import java.util.*;

class Solution {
    static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int ans;
	static int N, M;
    
    public static int solution(int[][] maps) {
		ans = Integer.MAX_VALUE;
        N = maps.length;
        M = maps[0].length;
        
        bfs(maps);
        
        if (ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }
	private static void bfs(int[][] maps) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
        maps[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int r = node[0]; int c = node[1];
			int time = node[2];
			
			if (r == N-1 && c == M-1) {
				ans = Math.min(ans, time);
	        	return;
			}
			
			for (int d = 0; d < 4; d++) {
	    		int nr = r + dr[d];
	    		int nc = c + dc[d];
	    		if (0 <= nr && nr < N && 0 <= nc && nc < M && maps[nr][nc] == 1) {
	    			q.offer(new int[] {nr, nc, time+1});
                    maps[nr][nc] = 0;
	    		}
	    	} 
		}
	}
}