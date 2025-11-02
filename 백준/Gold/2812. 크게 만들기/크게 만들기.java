import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String val = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Character now = val.charAt(i);
            while (!stack.isEmpty() && stack.peek() < now && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(now);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char num : stack) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}
