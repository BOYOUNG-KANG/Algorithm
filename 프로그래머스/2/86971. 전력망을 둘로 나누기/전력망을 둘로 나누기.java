import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	//bfs
	
	public static int solution(int n, int[][] wires) {
        int min = n;
        
        for (int i = 0; i < wires.length; i++) {
        	 List<int[]> temp = new ArrayList<>();
             for (int j = 0; j < wires.length; j++) {
                 if (i != j) {
                     temp.add(Arrays.copyOf(wires[j], wires[j].length));
                 }
             }
        	
        	int count = bfs(temp, n);
        	int value = n-count;
        	
        	min = Math.min(min, Math.abs(count-value));
        }
        return min;
    }
	
	private static int bfs(List<int[]> temp, int n) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
    	visited[1] = true;
    	
    	q.add(1);
    	int count = 1;
    	
    	while (!q.isEmpty()) {
    		int v = q.poll();
    		for (int[] t : temp) {
    			if (t[0] == v && !visited[t[1]]) {
    				visited[t[1]] = true;
    				count++;
    				q.add(t[1]);
    			} else if (t[1] == v && !visited[t[0]]) {
    				visited[t[0]] = true;
    				count++;
    				q.add(t[0]);
    			}
    		}
    	}
    	return count;
	}
}
