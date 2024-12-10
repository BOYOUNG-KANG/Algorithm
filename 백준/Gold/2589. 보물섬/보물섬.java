import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            char[] tmp = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                map[r][c] = tmp[c];
            }
        }
        ans = Integer.MIN_VALUE;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 'L') {
                    visited = new boolean[n][m];
                    visited[r][c] = true;
                    bfs(r, c, 0);
                }
            }
        }
        System.out.println(ans);
    }
    private static void bfs(int r, int c, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, count});

        while (!q.isEmpty()) {
            int[] ele = q.poll();
            r = ele[0];
            c = ele[1];
            count = ele[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && map[nr][nc] == 'L') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, count + 1});
                }
            }
        }
        ans = Math.max(ans, count);
    }
}
