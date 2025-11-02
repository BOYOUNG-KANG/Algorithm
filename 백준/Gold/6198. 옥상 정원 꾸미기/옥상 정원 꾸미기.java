import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<int[]> stack = new ArrayDeque<>();
        int[] blockFloor = new int[n];

        Arrays.fill(blockFloor, 0);
        long sum = 0;

        for (int i = n-1; i >=0 ; i--) {
            int nowfloor = arr[i];
            int count = 0;

            while (!stack.isEmpty() && stack.peek()[0] < nowfloor) {
                count += stack.pop()[1] + 1;
            }

            if (!stack.isEmpty()) {
                blockFloor[i] = stack.peek()[1];
            }
            stack.push(new int[]{nowfloor, count});
            sum += count;
        }
        System.out.println(sum);
    }
}
