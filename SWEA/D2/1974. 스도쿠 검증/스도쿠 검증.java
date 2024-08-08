import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int[][] map = new int[9][9];
			for (int r = 0; r < 9; r++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int c = 0; c < 9; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 1;
			for (int j = 0; j < 9; j++) {
				boolean[] checkerRow = new boolean[10];
				boolean[] checkerCol = new boolean[10];
				for (int k = 0; k < 9; k++) {
					checkerRow[map[j][k]] = true;
					checkerCol[map[k][j]] = true;
				}
				if(!check(checkerRow)) {
					result = 0;
				}
				if(!check(checkerCol)) {
					result = 0;
				}
			}
			
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					int nowr = r * 3;
					int nowc = c * 3;
					boolean[] checkerCube = new boolean[10];
					for (int j = nowr; j < nowr+3; j++) {
						for (int k = nowc; k < nowc+3; k++) {
							checkerCube[map[j][k]] = true;
						}
					}
					if(!check(checkerCube)) {
						result = 0;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
	static boolean check(boolean[] checker) {
		for (int i = 1; i < checker.length; i++) {
			if (checker[i] == false) {
				return false;
			}
		}
		return true;
	}
}