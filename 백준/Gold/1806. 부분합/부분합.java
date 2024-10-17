import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int v = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            v += arr[i];
        }
        int min = N;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum >= S) {
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }

        System.out.println(v < S ? 0 : min);
    }
}
