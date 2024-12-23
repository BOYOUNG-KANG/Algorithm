import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    int n;
    int price;

    public Node(int n, int price) {
        this.n = n;
        this.price = price;
    }

    @Override
    public int compareTo(Node o) {
        return this.price - o.price;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long ans = Integer.MAX_VALUE;

        int[] distfrom1 = dijkstra(1, graph, n);
        int[] distfromv1 = dijkstra(v1, graph, n);
        int[] distfromv2 = dijkstra(v2, graph, n);

        // 1 -> v1 -> v2 -> n
        // 1 -> v2 -> v1 -> n
        long path1 = (long) distfrom1[v1] + distfromv1[v2] + distfromv2[n];
        long path2 = (long) distfrom1[v2] + distfromv2[v1] + distfromv1[n];
        ans = Math.min(path1, path2);
        System.out.println(ans >= Integer.MAX_VALUE ? -1 : ans);
    }
    private static int[] dijkstra(int start, List<Node>[] graph, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.n] < now.price) continue;

            for (Node next : graph[now.n]) {
                if (dist[next.n] > now.price + next.price) {
                    dist[next.n] = now.price + next.price;
                    pq.add(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist;
    }
}
