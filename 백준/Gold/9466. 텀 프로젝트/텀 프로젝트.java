import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static boolean[] done;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            done = new boolean[n+1];
            result = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - result);
        }
    }
    private static void dfs(int now){
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!done[next]){
            result++;
            for (int i = next; i != now; i = arr[i]) result++;
        }

        done[now] = true;
    }
}
