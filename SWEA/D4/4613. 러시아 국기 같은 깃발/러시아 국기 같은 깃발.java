import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			int result = 0;
			int[][] colorCount = new int[3][N];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < N; c++) {
					colorCount[r][c] = M;
				}
			}
			for (int r = 0; r < N; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 'W') {
						colorCount[0][r]--;
					} else if (map[r][c] =='B') {
						colorCount[1][r]--;
					} else if (map[r][c] =='R') {
						colorCount[2][r]--;
					}
				}
			}
			
			int[][] matrix = new int[3][N];
			matrix[1][0] = 10000; matrix[2][0] = 10000; matrix[2][1] = 10000;
			matrix[0][N-1] = 10000; matrix[0][N-2] = 10000; matrix[1][N-1] = 10000;
			
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < N; c++) {
					int prevR = r - 1;
					int prevC = c - 1;
					if (matrix[r][c] != 10000 && 0 <= prevR && prevR < 3 && 0 <= prevC && prevC < N) {
						matrix[r][c] = Math.min(colorCount[r][c] + matrix[r][prevC], colorCount[r][c] + matrix[prevR][prevC]);
					} else if (matrix[r][c] != 10000 && 0 <= prevC && prevC < N) {
						matrix[r][c] = colorCount[r][c] + matrix[r][prevC];
					} else if (matrix[r][c] != 10000){
						matrix[r][c] = colorCount[r][c];
					} else {
						continue;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+matrix[2][N-1]);
		}
	}
}