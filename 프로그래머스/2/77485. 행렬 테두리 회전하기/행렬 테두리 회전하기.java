import java.util.*;

class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        
        int val = 1;
        for (int y = 0; y < rows; y++) { // 초기 map 세팅
            for (int x = 0; x < columns; x++) {
                map[y][x] = val;
                val++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;
            
            int min = Integer.MAX_VALUE;
            
            // 숫자 옮기기
            int prev = map[r1][c1];
            for (int x = c1 + 1; x <= c2; x++) {
                int y = r1;
                int tmp = map[y][x];
                min = Math.min(min, tmp); //최소값 구하기
                map[y][x] = prev;
                prev = tmp;
            }
            
            for (int y = r1 + 1; y <= r2; y++) {
                int x = c2;
                int tmp = map[y][x];
                min = Math.min(min, tmp);
                map[y][x] = prev;
                prev = tmp;
            }
            
            for (int x = c2 - 1; x >= c1; x--) {
                int y = r2;
                int tmp = map[y][x];
                min = Math.min(min, tmp);
                map[y][x] = prev;
                prev = tmp;
            }
            
            for (int y = r2 - 1; y >= r1; y--) {
                int x = c1;
                int tmp = map[y][x];
                min = Math.min(min, tmp);
                map[y][x] = prev;
                prev = tmp;
            }
            
            answer[i] = min; // 제일 작은 값 추가
        }
        
        return answer;
    }
}