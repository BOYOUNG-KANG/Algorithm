import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static int[] solution(int[] answers) {
		int[] p1 = {1, 2, 3, 4, 5};
		int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] results = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == p1[i % p1.length]) {
				results[0]++;
			}
			if (answers[i] == p2[i % p2.length]) {
				results[1] ++;
			}
			if (answers[i] == p3[i % p3.length]) {
				results[2]++;
			}
		}
		
		Integer[] sortedArr = Arrays.stream(results).boxed().toArray(Integer[]::new);
		Arrays.sort(sortedArr, Comparator.reverseOrder());
		List<Integer> temp = new ArrayList<>(); int idx = 0;
		for (int i = 0; i < 3; i++) {
			if (results[i] == sortedArr[0]) {
				temp.add(i+1);
			}
		}
		int[] t = new int[temp.size()];
		for (int i = 0; i < t.length; i++) {
			t[i] = temp.get(i);
		}
        return t;
    }
}