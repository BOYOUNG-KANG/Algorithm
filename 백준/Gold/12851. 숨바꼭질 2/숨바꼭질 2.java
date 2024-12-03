import java.io.*;
import java.util.*;

public class Main {
    static int[] time = new int[100001];
    static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] bfs = bfs(n, k);
        System.out.println(bfs[0]);
        System.out.println(bfs[1]);
    }
    static int[] bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 0;
        count[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) {
                return new int[]{time[target], count[target]};
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now * 2;
                }

                if (next < 0 || next > 100000) continue;
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    if (time[next] == 0) {
                        q.offer(next);
                        time[next] = time[now] + 1;
                    }
                    count[next] += count[now];
                }
            }
        }
        return new int[]{-1};
    }
}
