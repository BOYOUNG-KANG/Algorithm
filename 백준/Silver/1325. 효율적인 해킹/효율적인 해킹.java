import java.io.*;
import java.util.*;

public class Main {
    static int maxCnt;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        maxCnt = 0;

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int ele1 = Integer.parseInt(st.nextToken());
            int ele2 = Integer.parseInt(st.nextToken());
            map.get(ele2).add(ele1);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            int count = dfs(i, n, map,  visited);
            if (maxCnt < count) {
                maxCnt = count;
                list = new ArrayList<>();
                list.add(i);
            } else if (maxCnt == count) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
    private static int dfs(int idx, int n, List<List<Integer>> map, boolean[] visited) {
        visited[idx] = true;
        int count = 1;
        for (int ele : map.get(idx)) {
            if (!visited[ele]) {
                count += dfs(ele, n, map, visited);
            }
        }

        return count;
    }
}
