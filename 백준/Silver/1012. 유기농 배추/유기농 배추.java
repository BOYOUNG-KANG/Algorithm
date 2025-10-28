import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static int x;
    static int y;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            ans = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map = new int[x][y];
            visited = new boolean[x][y];
            cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int lx = Integer.parseInt(st.nextToken());
                int ly = Integer.parseInt(st.nextToken());
                map[lx][ly] = 1;
            }
            int wormCnt = 0;
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        dfs(j, k);
                        wormCnt++;
                    }
                }
            }
            System.out.println(wormCnt);
        }
    }
    private static void dfs(int nx, int ny){
        visited[nx][ny] = true;

        for (int d = 0; d < 4; d++) {
            int nextX = nx + dx[d];
            int nextY = ny + dy[d];

            if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
        }
    }
}
