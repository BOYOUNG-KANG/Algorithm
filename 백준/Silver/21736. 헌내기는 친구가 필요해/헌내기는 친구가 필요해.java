import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);

                if (map[i][j] == 'I') {
                    x = i; y = j;
                }
            }
        }
        visited[x][y] = true;
        dfs(x, y);
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {


        for (int d = 0; d < 4; d++) {
            int tmpx = x + dx[d];
            int tmpy = y + dy[d];

            if (tmpx >= 0 && tmpx < n && tmpy >= 0 && tmpy < m && !visited[tmpx][tmpy]) {
                visited[tmpx][tmpy] = true;
                if (map[tmpx][tmpy] == 'O'|| map[tmpx][tmpy] == 'P') {
                    if (map[tmpx][tmpy] == 'P') count++;
                    dfs(tmpx, tmpy);
                }

            }

        }
    }
}
