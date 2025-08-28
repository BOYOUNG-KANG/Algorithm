import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int minV = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            int tmpV = bfs(i);
            if (tmpV < minV) {
                minV = tmpV;
                ans = i;
            }
        }
        System.out.println(ans);
    }
    private static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != -1) {
                sum += dist[i];
            }
        }
        return sum;
    }
}
