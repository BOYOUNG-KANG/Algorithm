import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Comparator.reverseOrder());
        for (int i = 0; i < integers.length; i++) {
            if (i + 1 > integers[i]) {
                return i;
            }
        }
        return integers.length;
    }
}