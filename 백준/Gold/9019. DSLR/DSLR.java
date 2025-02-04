import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int num;
        String value;

        Node(int num, String value) {
            this.num = num;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            System.out.println(bfs(before, after));
        }
    }
    private static String bfs(int before, int after) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Node(before, ""));
        visited[before] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.num == after) return now.value;

            int next = (now.num * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.value + "D"));
            }

            next = (now.num == 0) ? 9999 : now.num - 1;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.value + "S"));
            }

            next = (now.num % 1000) * 10 + now.num / 1000;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.value + "L"));
            }

            next = (now.num % 10) * 1000 + now.num / 10;
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.value + "R"));
            }
        }
        return "";
    }
}
