import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) visited[i][j] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            bfs(i);
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            if (map[start][j] == 1) {
                q.add(j);
            }
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            boolean full = true;
            for (int t = 0; t < n; t++) {
                if (!visited[start][t])  full = false;
            }
            if (full == true) {
                return;
            }

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && map[start][j] == 0 && !visited[start][j]) {
                    map[start][j] = 1;
                    visited[start][j] = true;
                    q.add(j);
                }
            }
        }
    }
}
