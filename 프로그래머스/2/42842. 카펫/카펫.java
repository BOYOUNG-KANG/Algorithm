import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // y <= x
        //(x-1) * (y-1) = yellow
        //y * x = brown + yellow
        int sum = brown + yellow;
        
        for (int y = 1; y < sum; y++ ) {
            for (int x = 1; x <= y; x++) {
                if (y * x == sum && ((y-2) * (x-2) == yellow)) {
                    System.out.println("y * x="+y * x);
                    answer[0] = y;
                    answer[1] = x;
                    return answer;
                }
            }
        }
        return answer;
    }
}