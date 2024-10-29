import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxV = 0;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            maxV = Math.max(maxV, list[i]);
        }
        System.out.println(bineary(0, maxV));
    }
    public static long bineary(long start, long end) {
        if (start > end) {
            return end;
        }
        long mid = (start + end) / 2;
        long sum = 0;
        for (int i  = 0; i < n; i++) {
            if (list[i] > mid) {
                sum += (list[i] - mid);
            }
        }

        if (sum >= m) {
            return bineary(mid+1, end);
        } else {
            return bineary(start, mid-1);
        }
    }
}