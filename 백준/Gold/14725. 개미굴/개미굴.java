import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        TreeMap<String, Node> map = new TreeMap<>();
    }
    static void print(int depth, Node node) {
        for (String key : node.map.keySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            print(depth + 1, node.map.get(key));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node node = new Node();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            Node cur = node;
            for (int j = 0; j < m; j++) {
                String ele = st.nextToken();
                cur = cur.map.computeIfAbsent(ele, k -> new Node());
            }
        }
        print(0, node);
    }
}
