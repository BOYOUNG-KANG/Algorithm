import java.util.*;

class Solution {
    static boolean[][][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    
    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[11][11][4];
        int x = 5; int y = 5; //처음 시작 위치: 5, 5
        
        for (char dir : dirs.toCharArray()) {    
            if (dir == 'U') { //상
                int nx = x + dx[0];
                int ny = y + dy[0];
                if (0 <= ny && ny < 11 && 0 <= nx && nx < 11){
                    if (!visited[y][x][0]) {
                        answer++;
                        visited[y][x][0] = true;
                        visited[ny][nx][1] = true;
                    }
                    x = nx; y = ny;
                }
                
            } else if (dir == 'D') { //하
                int nx = x + dx[1];
                int ny = y + dy[1];
                if (0 <= ny && ny < 11 && 0 <= nx && nx < 11){
                    if (!visited[y][x][1]) {
                        answer++;
                        visited[y][x][1] = true;
                        visited[ny][nx][0] = true;
                    }
                    x = nx; y = ny;
                }
            } else if (dir == 'L') { //좌
                int nx = x + dx[2];
                int ny = y + dy[2];
                if (0 <= ny && ny < 11 && 0 <= nx && nx < 11){
                    if (!visited[y][x][2]) {
                        answer++;
                        visited[y][x][2] = true;
                        visited[ny][nx][3] = true;
                    }
                    x = nx; y = ny;
                }
            } else { //우
                int nx = x + dx[3];
                int ny = y + dy[3];
                if (0 <= ny && ny < 11 && 0 <= nx && nx < 11){
                    if (!visited[y][x][3]) {
                        answer++;
                        visited[y][x][3] = true;
                        visited[ny][nx][2] = true;
                    }
                    x = nx; y = ny;
                }
            }
        }  
        return answer;
    }
}