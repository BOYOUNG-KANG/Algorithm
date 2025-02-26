import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
    private static void dfs(int start, int now) {
        for (int next = 0; next < n; next++) {
            if (map[now][next] == 1 && !visited[start][next]) {
                map[start][next] = 1;
                visited[start][next] = true;
                dfs(start, next);
            }
        }
    }
}
