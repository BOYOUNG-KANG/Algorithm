import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int area;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int max = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    area = 1;
                    dfs(y, x);
                    cnt++;
                    max = Math.max(max, area);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
    private static void dfs(int y, int x){
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                area++;
                dfs(ny, nx);
            }
        }
    }

}

