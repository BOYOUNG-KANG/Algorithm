import java.io.*;
import java.util.*;

public class Main {
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int bridge = Integer.parseInt(st.nextToken());

            int[] visited = new int[node+1];
            ans = "YES";
            List<List<Integer>> list = new ArrayList<>();

            for (int j = 0; j <= node; j++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < bridge; i++) {
                st = new StringTokenizer(br.readLine());
                int ele1 = Integer.parseInt(st.nextToken());
                int ele2 = Integer.parseInt(st.nextToken());
                list.get(ele1).add(ele2);
                list.get(ele2).add(ele1);
            }

            for (int j = 1; j <= node; j++) {
                if (ans.equals("NO")) {
                    break;
                }
                if (visited[j] == 0) {
                    dfs(visited, list, j, 1);
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int[] visited, List<List<Integer>> list, int nowIdx, int color) {
        visited[nowIdx] = color;

        for (int near : list.get(nowIdx)) {
            if (visited[near] == color) {
                ans = "NO";
                return;
            }
            if (visited[near] == 0) {
                dfs(visited, list, near, -color);
            }
        }
    }
}
