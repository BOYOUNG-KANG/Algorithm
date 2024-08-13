import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int solution(int k, int[][] dungeons) {
		int max = 0;
		boolean[] isVisited = new boolean[dungeons.length];
		List<int[]> permutation = new ArrayList<>();
		perm(dungeons, isVisited, new ArrayList<>(), permutation);
		
		for (int[] perms : permutation) {
			int remain = k;
			int count = 0;
			for (int i = 0; i < perms.length; i++) {
				if (remain >= dungeons[perms[i]][0]) {
					remain -= dungeons[perms[i]][1];
					count++;
				} else {
					break;
				}
			}
			max = Math.max(max, count);
		}
		
		return max;
	}
	private static void perm(int[][] dungeons, boolean[] isVisited, List<Integer> tempList, List<int[]> result) {
		if (tempList.size() == dungeons.length) {
			result.add(tempList.stream().mapToInt(i -> i).toArray());
		} else {
			for (int i = 0; i < dungeons.length; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					tempList.add(i);
					perm(dungeons, isVisited, tempList, result);
					isVisited[i] = false;
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	} 
}