import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);
            s = Integer.parseInt(st.nextToken());
            if (s != 0) {
                arr = new int[s];
                for (int i = 0; i < s; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                com(0, 0, new int[6]);
                System.out.println();
            }
        }

    }
    private static void com(int idx, int arrIdx, int[] result) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = arrIdx; i < s; i++) {
            result[idx] = arr[i];
            com(idx + 1, i + 1, result);
        }
    }
}
