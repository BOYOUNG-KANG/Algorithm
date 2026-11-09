import java.util.*;

public class Main {
    public static int n, m;
    public static int[] A;
    public static int maxV;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        maxV = Integer.MIN_VALUE;
        //visited[0] = true;
        List<Integer> val = new LinkedList<>();
        //val.add(A[0]);
        dfs(val, -1);
        System.out.println(maxV);
    }
    public static void dfs(List<Integer> val, int idx) {
        if (val.size() == m) {
            //System.out.println(val.toString());
            int tmp = val.get(0);
            for (int i = 1; i < val.size(); i++) {
                tmp ^= val.get(i);
            }
            maxV = Math.max(maxV, tmp);
            return;
        }

        for (int i = idx+1; i < n; i++) {
                val.add(A[i]);
                dfs(val, i);
                val.remove(val.size()-1);
        }
        return;
    }
}