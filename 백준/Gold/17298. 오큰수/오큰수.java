import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n];

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-1; i >= 0; i--) {
            int now = list[i];

            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.push(now);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
