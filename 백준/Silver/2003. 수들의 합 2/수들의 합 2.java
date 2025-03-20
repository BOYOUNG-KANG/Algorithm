import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int nowV = 0;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            nowV += list[i];

            while (nowV > m) {
                nowV -= list[startIdx++];
            }
            if (nowV == m) {
                count++;
            }
        }
        System.out.println(count);
    }
}
