import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] list;
    static long[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        ans = new long[tc];

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            list = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            int maxV = 0;
            long profit = 0;
            for (int j = n-1; j >= 0; j--) {
                if (list[j] > maxV) {
                    maxV = list[j];
                }
                profit += maxV - list[j];
            }
            ans[i] = profit;
        }
        for (int i = 0; i < tc; i++) {
            System.out.println(ans[i]);
        }
    }
}
