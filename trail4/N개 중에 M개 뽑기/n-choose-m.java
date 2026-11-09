import java.util.*;

public class Main {
    public static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        dfs(new LinkedList<>(), visited, 0);
        
    }
    private static void dfs(List<Integer> val, boolean[] visited, int idx) {
        if (val.size() == m) {
            for (int i = 0; i < val.size(); i++) {
                System.out.print(val.get(i)+ " ");
            }
            System.out.println();
            return;
        } else if (val.size() > m) {
            return;
        }

        for (int i = idx+1; i <= n; i++) {
            if (!visited[i]) {
                val.add(i);
                visited[i] = true;
                dfs(val, visited, i);
                val.remove(val.size()-1);
                visited[i] = false;
            }
        }
        return;
    }
}