import java.util.*;

class Solution {
    static int[] dy = new int[]{1, -1, 0, 0}; // 상하좌우
    static int[] dx = new int[]{0, 0, -1, 0};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] left = new int[]{-2, -1}; // *
        int[] right = new int[]{-2, 1}; // #
        
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 1) { //왼손
                answer.append("L");
                left[0] = 1;
                left[1] = -1;
            } else if ( n == 4 ) { //왼손
                answer.append("L");
                left[0] = 0;
                left[1] = -1;
            } else if ( n == 7) { //왼손
                answer.append("L");
                left[0] = -1;
                left[1] = -1;
            } else if (n == 3) { //오른손
                answer.append("R");
                right[0] = 1;
                right[1] = 1;
            } else if (n == 6 ) { //오른손
                answer.append("R");
                right[0] = 0;
                right[1] = 1;
            } else if (n == 9) { //오른손
                answer.append("R");
                right[0] = -1;
                right[1] = 1;
            } else if (n == 2) { // 가까운 손 계산
                int leftD = Math.abs(1 - left[0]) + Math.abs(0 - left[1]);
                int rightD = Math.abs(1 - right[0]) + Math.abs(0 - right[1]);   
                
                if (leftD > rightD) {
                    answer.append("R");
                    right[0] = 1;
                    right[1] = 0;
                } else if (leftD < rightD) {
                    answer.append("L");
                    left[0] = 1;
                    left[1] = 0;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right[0] = 1;
                        right[1] = 0;
                    } else {
                        answer.append("L");
                        left[0] = 1;
                        left[1] = 0;
                    }
                }
                 
            } else if (n == 5) { // 가까운 손 계산
                int leftD = Math.abs(0 - left[0]) + Math.abs(0 - left[1]);
                int rightD = Math.abs(0 - right[0]) + Math.abs(0 - right[1]);   
                
                if (leftD > rightD) {
                    answer.append("R");
                    right[0] = 0;
                    right[1] = 0;
                } else if (leftD < rightD) {
                    answer.append("L");
                    left[0] = 0;
                    left[1] = 0;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right[0] = 0;
                        right[1] = 0;
                    } else {
                        answer.append("L");
                        left[0] = 0;
                        left[1] = 0;
                    }
                }
            } else if (n == 8) { // 가까운 손 계산
                int leftD = Math.abs(-1 - left[0]) + Math.abs(0 - left[1]);
                int rightD = Math.abs(-1 - right[0]) + Math.abs(0 - right[1]);   
                
                if (leftD > rightD) {
                    answer.append("R");
                    right[0] = -1;
                    right[1] = 0;
                } else if (leftD < rightD) {
                    answer.append("L");
                    left[0] = -1;
                    left[1] = 0;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right[0] = -1;
                        right[1] = 0;
                    } else {
                        answer.append("L");
                        left[0] = -1;
                        left[1] = 0;
                    }
                }
            } else if (n == 0) { // 가까운 손 계산
                int leftD = Math.abs(-2 - left[0]) + Math.abs(0 - left[1]);
                int rightD = Math.abs(-2 - right[0]) + Math.abs(0 - right[1]);   
                
                if (leftD > rightD) {
                    answer.append("R");
                    right[0] = -2;
                    right[1] = 0;
                } else if (leftD < rightD) {
                    answer.append("L");
                    left[0] = -2;
                    left[1] = 0;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right[0] = -2;
                        right[1] = 0;
                    } else {
                        answer.append("L");
                        left[0] = -2;
                        left[1] = 0;
                    }
                }
            }
            
        }
        
        return answer.toString();
    }
}