import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][2];
        dp = new int[n+2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i <= n && i + map[i - 1][0] <= n + 1) {
                dp[i + map[i - 1][0]] = Math.max(dp[i + map[i - 1][0]], dp[i] + map[i - 1][1]);
            }
        }

        System.out.println(dp[n+1]);
    }
}
