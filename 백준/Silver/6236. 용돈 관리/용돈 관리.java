import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        ans = right;
        int target = m;
        binarySearch(left, right, target);
        System.out.println(ans);
    }
    private static void binarySearch(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int tmp = 1;
            int remain = mid;
            for (int i = 0; i < n; i++) {
                if (arr[i] > remain) {
                    tmp++;
                    remain = mid;
                }
                remain -= arr[i];
            }

            if (tmp <= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
