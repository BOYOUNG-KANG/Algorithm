import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[j] - '0';
            }
        }

        dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int ans = bfs();
        System.out.println(ans);
    }
    private static int bfs() {
        Deque<int[]> deque = new LinkedList<>();
        dist[0][0] = 0;
        deque.addFirst(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0]; int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    int newDist = dist[x][y] + map[nx][ny];

                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        if (map[nx][ny] == 1) {
                            deque.addLast(new int[]{nx, ny});
                        } else {
                            deque.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
