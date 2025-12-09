import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (right < n) {
            if (arr[right] == 1) sum++;
            right++;

            while (sum >= k) {
                min = Math.min(min, right - left);
                if (arr[left] == 1) sum--;
                left++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
