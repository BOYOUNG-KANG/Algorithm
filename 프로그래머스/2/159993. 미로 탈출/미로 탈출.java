import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int xL;
    static int yL;
    static int totalCnt = Integer.MAX_VALUE;
    static int totalCnt2 = Integer.MAX_VALUE;
    
    public int solution(String[] maps) {
        xL = maps.length;
        yL = maps[0].length();
        map = new char[xL][yL];
        visited = new boolean[xL][yL];

        int[] start = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < xL; i++) {
            for (int j = 0; j < yL; j++) {
                char tmp = maps[i].charAt(j);
                map[i][j] = tmp;
                if (tmp == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (tmp == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int dist1 = bfs(start[0], start[1], 'L');
        if (dist1 == -1) return -1;
        visited = new boolean[xL][yL];
        int dist2 = bfs(lever[0], lever[1], 'E');
        if (dist2 == -1) return -1;

        return dist1 + dist2;
    }
    
    private static int bfs(int x,int y, char alpha){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                int dist = now[2] + 1;

                if (0 <= nx && nx < xL && 0 <= ny && ny < yL && !visited[nx][ny] && map[nx][ny] != 'X') {
                    if (map[nx][ny] == alpha) {
                        return dist;
                    }
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist});
                }
            }
        }
        return -1;
    }
}