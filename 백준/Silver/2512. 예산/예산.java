import java.io.*;
import java.util.*;

public class Main  {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            max = Math.max(max, arr[i]);
        }
        m = Integer.parseInt(br.readLine());

        int result = 0;
        if (total <= m) {
            System.out.println(max);
            return;
        }

        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (right + left) / 2;

            int now = 0;
            for(int i = 0; i < n; i++) {
                now += (arr[i] < mid)? arr[i] : mid;
            }

            if (now <= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

}
