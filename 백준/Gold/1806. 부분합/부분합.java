import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int n;
    static int s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0; int start = 0; int end = 0;

        while (true) {
            if (now >= s) {
                ans = Math.min(ans, end - start);
                now -= arr[start++];
            } else if (end == n) break;
            else now += arr[end++];
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(ans);
    }
}