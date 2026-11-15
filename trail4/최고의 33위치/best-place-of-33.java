import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int val = Integer.MIN_VALUE;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int sum = 0;
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        if (grid[i+y][j+x] == 1) sum++;
                    }
                }

                val = Math.max(sum, val);
            }
        }

        System.out.println(val);
    }
}