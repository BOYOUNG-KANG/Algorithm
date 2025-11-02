import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 0);
        Deque<int[]> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int now = arr[i];

            while (!stack.isEmpty() && stack.peek()[1] <= now) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek()[0] + 1;
            }

            stack.push(new int[]{i, now});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
