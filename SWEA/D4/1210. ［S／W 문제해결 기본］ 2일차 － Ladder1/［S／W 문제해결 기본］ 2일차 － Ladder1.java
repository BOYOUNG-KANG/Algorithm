import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int[] dr = {0, 0}; //왼오
	static int[] dc = {-1, 1};
	static int[][] map = new int[100][102];
	
	public static int bridge(int r, int nowC, int d) {
		for (int j = 0; j < 102; j++) {
			int nextC = nowC + dc[d];
			if (0 <= nextC && nextC < 102) {
				if (map[r][nextC] == 1) {
					nowC = nextC;
				} else {
					return nowC;
				}
			}
		}
		return nowC;
	}
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < 100; j++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int k = 1; k < 101; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int nowC = 0;
			for (int c = 1; c < 101; c++) {
				if (map[99][c] == 2) 
					nowC = c;
			}
			for (int r = 99; r >= 0; r--) {
				int leftC = nowC + dc[0]; int rightC = nowC + dc[1];
				if (0 <= leftC && leftC < 102 && 0 <= rightC && rightC < 102) {
					if (map[r][leftC] == 1) {
						nowC = bridge(r, leftC, 0);
						continue;
					} else if (map[r][rightC] == 1) {
						nowC = bridge(r, rightC, 1);
						continue;
					}
				}
			}
			System.out.println("#"+t+" "+(nowC-1));
		}
	}
}