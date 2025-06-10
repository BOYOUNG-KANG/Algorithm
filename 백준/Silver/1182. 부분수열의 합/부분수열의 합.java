import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
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
        powerset(0, 0);

        if (s == 0) count--;
        System.out.println(count);
    }
    private static void powerset(int idx, int now) {
        if (idx >= n) {
            if (now == s) count++;
            return;
        }

        powerset(idx+1, now);
        powerset(idx+1, now+arr[idx]);

    }
}
