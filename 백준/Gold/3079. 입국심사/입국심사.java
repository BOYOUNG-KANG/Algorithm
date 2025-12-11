import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long left = 1;
        long right = (long) arr[n-1] * m;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / arr[i];
                if (cnt >= m) break;
            }

            if (cnt >= m) { //시간 최소값 탐색
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
