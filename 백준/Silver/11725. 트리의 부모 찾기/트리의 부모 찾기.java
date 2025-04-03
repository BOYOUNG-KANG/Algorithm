import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parents;
    static boolean[] visited;
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int i : list[idx]) {
            if (!visited[i]) {
                parents[i] = idx;
                dfs(i);
            }
        }
    }
}
