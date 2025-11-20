import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] target;
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        target = new int[2];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if (map[y][x] == 2) { // 목표지점 구하기
                    target[0] = y;
                    target[1] = x;
                }
            }
        }
        bfs(target[0], target[1]);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    result[y][x] = -1;
                }
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }
    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        result[y][x] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextY = now[0] + dy[d];
                int nextX = now[1] + dx[d];

                if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m && map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    result[nextY][nextX] = result[now[0]][now[1]] + 1;
                    q.add(new int[]{nextY, nextX});
                }
            }

        }
    }
}
