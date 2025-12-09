import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int result = 0;
        int count = 1;

        while (left <= n) {
            if (count == n) {
                result++;
                count -= left;
                left++;
            } else if (count < n) {
                right++;
                if (right > n) break;
                count += right;
            } else {
                count -= left;
                left++;
            }
        }
        System.out.println(result);
    }
}
