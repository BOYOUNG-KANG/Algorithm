import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxV = Integer.MIN_VALUE;
        int count = 0;
        int startIdx = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += arr[i];
            count++;
            if (count > k) {
                tmp -= arr[startIdx];
                startIdx++;
                count--;
            }
            if (count == k) {
                maxV = Math.max(maxV, tmp);
            }
        }

        System.out.println(maxV);
    }
}
