
import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int r, c;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (n == 1) {
            print();
            return;
        }

        if (n % 2 == 0){
            fillbomb();
            print();
            return;
        }

        explode();

        if (n % 4 == 3) {
            print();
            return;
        }

        explode();
        print();
    }

    static void explode(){
        boolean[][] isBoom = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    isBoom[i][j] = true;

                    for (int d = 0; d < 4; d++) {
                        int ny = i + dx[d];
                        int nx = j + dy[d];

                        if (0 <= ny && ny < r && 0 <= nx && nx < c) {
                            isBoom[ny][nx] = true;
                        }
                    }
                }
            }
        }

        char[][] next = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (isBoom[i][j]) {
                    next[i][j] = '.';
                }else {
                    next[i][j] = 'O';
                }
            }
        }
        map = next;
    }

    static void fillbomb(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = 'O';
            }
        }
    }

    static void print(){
        for (int i = 0; i < r; i++) {
            System.out.println(map[i]);
        }
    }
}
