import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            Deque<Integer> sorted = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int result = 0;
            sorted.add(arr[n-1]); // 젤 큰 수 넣기

            boolean isLeft = true;
            for (int j = n-2; j >= 0; j--) {
                if (isLeft) {
                    sorted.addFirst(arr[j]);
                    result = Math.max(result, (sorted.getFirst()-arr[j]));
                    isLeft = false;
                } else {
                    sorted.addLast(arr[j]);
                    result = Math.max(result, (sorted.getLast()-arr[j]));
                    isLeft = true;
                }
            }

            int[] res = sorted.stream().mapToInt(Integer::intValue).toArray();
            for (int j = 0; j < n; j++) {
                result = Math.max(result, Math.abs(res[j] - res[(j + 1) % n]));
            }

            System.out.println(result);
        }

    }
}
