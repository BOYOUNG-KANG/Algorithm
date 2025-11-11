import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        int result = Integer.MAX_VALUE;
        int cnt = bfs(n, k);

        result = Math.min(result, cnt);
        System.out.println(result);
    }
    private static int bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                return dist[k];
            }

            int[] nDist = new int[]{now + 1, now - 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = nDist[i];
                if (0 <= next && next <= 100000 && next != n && dist[next] == 0) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}
