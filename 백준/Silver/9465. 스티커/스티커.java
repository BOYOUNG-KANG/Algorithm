import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n][2];
            int[][] dp = new int[n][2];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j][0] = Integer.parseInt(st1.nextToken());
                arr[j][1] = Integer.parseInt(st2.nextToken());

            }
            if (n == 1) {
                System.out.println(Math.max(arr[0][0], arr[0][1]));
                continue;
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[1][0] = Math.max(0, dp[0][1]) + arr[1][0];
            dp[1][1] = Math.max(0, dp[0][0]) + arr[1][1];

            for (int j = 2; j < n; j++) {
                int tmp = Math.max(dp[j-2][1], dp[j-2][0]);
                dp[j][0] = Math.max(dp[j-1][1], tmp) + arr[j][0];

                tmp = Math.max(dp[j-2][0], dp[j-2][1]);
                dp[j][1] = Math.max(dp[j-1][0], tmp) + arr[j][1];
            }

            System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));

        }
    }
}
