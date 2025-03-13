import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] list = new int[n+k];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int[] counter = new int[d + 1];
        int count = 0;
        int ans = 0;

        for (int i = 0; i < k; i++) {
            if (counter[list[i]] == 0) {
                count++;
            }
            counter[list[i]]++;
        }

        if (counter[c] == 0) {
            count++;
        }
        counter[c]++;

        ans = count;
        for (int i = 1; i < n; i++) {

            int removeSushi = list[i - 1];
            counter[removeSushi]--;
            if (counter[removeSushi] == 0) {
                count--;
            }

            int addSushi = list[(i + k - 1) % n];
            if (counter[addSushi] == 0) {
                count++;
            }
            counter[addSushi]++;

            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
