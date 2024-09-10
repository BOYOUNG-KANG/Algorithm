import java.util.*;

class Solution {
    static int[] p;
    public static int solution(int n, int[][] computers) {
        p = new int[n];
        
		//makeparent
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && computers[i][j] == 1 && findParent(i) != findParent(j)) {
					for (int k = 0; k < n; k++) {
						if (findParent(k) == findParent(j)) p[k] = findParent(i);
					}
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(p[i]);
		}
		System.out.println(set);
        return set.size();
    }
	private static int findParent(int x) {
		if (p[x] != x) p[x] = findParent(p[x]);
		return p[x];
	}
}