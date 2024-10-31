import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int start;
    static int end;
    static long res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dfs(start, 1);
        System.out.println(res);
    }
    private static void dfs(long result, long count) {
        if (result == end) {
            if (res == -1 || count < res) {
                res = count;
            }
            return;
        } else if (result > end) {
            return;
        }

        dfs(result * 2, count+1);
        dfs(result * 10 + 1, count+1);
    }
}
