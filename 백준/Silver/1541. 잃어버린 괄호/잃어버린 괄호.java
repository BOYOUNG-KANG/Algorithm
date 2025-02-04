import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("-");
        int ans = 0;

        for (int i = 0; i < word.length; i++) {
            String[] ele = word[i].split("\\+");
            int tmp = 0;
            for (int j = 0; j < ele.length; j++) {
                tmp += Integer.parseInt(ele[j]);
            }

            if (i == 0) {
                ans += tmp;
            } else {
                ans -= tmp;
            }
        }
        System.out.println(ans);
    }
}
