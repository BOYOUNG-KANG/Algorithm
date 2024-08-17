import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            char [] arr = br.readLine().toCharArray();
            int answer = 0;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] == '(' && arr[j+1] == ')') {
                    answer++;
                } else if (arr[j] == '(' && arr[j+1] == '|') {
                    answer++;
                } else if (arr[j] == '|' && arr[j+1] == ')') {
                    answer++;
                }
            }

            System.out.println("#"+(i+1)+" "+answer);
        }
    }
}