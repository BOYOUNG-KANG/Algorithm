import java.io.*;
import java.util.*;

public class Main {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        int cnt = 0;
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                cnt++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}
