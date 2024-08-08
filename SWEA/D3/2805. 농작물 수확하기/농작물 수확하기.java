import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	static int[] dr = {0, 0};
	static int[] dc = {-1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int result = 0; 
			for (int r = 0; r < n; r++) {
				String str = br.readLine();
				for (int c = 0; c < n; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}
			
			int mid = n / 2;
			for (int r = 0; r < n; r++) {
				result += map[r][mid];
				if (mid >= r && r != 0) {
					for (int l = 1; l <= r; l++) {
						result += map[r][mid+l];
						result += map[r][mid-l];
					}
				} else if (mid < r & r != n-1) {
					for (int l = 1; l < n-r; l++) {
						result += map[r][mid+l];
						result += map[r][mid-l];
					}
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}