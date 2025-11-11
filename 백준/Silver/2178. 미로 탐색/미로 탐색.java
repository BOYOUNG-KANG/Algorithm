import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        int result = Integer.MAX_VALUE;
        int cnt = bfs(0, 0);

        result = Math.min(cnt, result);
        System.out.println(result);
    }
    private static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            int cnt = now[2];

            if (nowy == n-1 && nowx == m-1) {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = nowx + dx[d];
                int ny = nowy + dy[d];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && !visited[ny][nx]) {
                    if (map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}
