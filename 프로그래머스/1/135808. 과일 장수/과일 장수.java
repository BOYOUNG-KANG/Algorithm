import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        int[] reversed = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            reversed[i] = score[score.length - i - 1];
        }
        
        for (int i = 0; i < score.length; i += m) {
            if (i + m - 1 < score.length) {
                answer += reversed[i+m-1] * m;
            }
        }
        return answer;
    }
}