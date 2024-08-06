import java.util.Arrays;
import java.util.Scanner;
class Solution
{
	public static void main(String[] args) {
		int[] dr = {0, 1, 0, -1}; 
		int[] dc = {1, 0, -1, 0};
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int[][] map = new int[m][m];
			
			int num = 1;
			int nowr = 0; int nowc = 0;int d = 0;
			map[nowr][nowc] = num++;
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					
					int nextr = nowr + dr[d];
					int nextc = nowc + dc[d];
					
					if (0 <= nextr && nextr < m && 0 <= nextc && nextc < m && map[nextr][nextc] == 0) {
						map[nextr][nextc] = num++;
						nowr = nextr; nowc = nextc;
					} else {
						if (d == 3) {
							d = 0;
						} else {
							d++;
						}
						nextr = nowr + dr[d];
						nextc = nowc + dc[d];
						if (0 <= nextr && nextr < m && 0 <= nextc && nextc < m && map[nextr][nextc] == 0) {
							
							map[nextr][nextc] = num++;
							nowr = nextr; nowc = nextc;
						} else {
							continue;
						}
					}
				}
			}
			System.out.println("#"+(i+1));
			for (int r = 0; r < m; r++) {
				for(int c = 0; c < m; c++) {
					System.out.print(map[r][c]+" ");
				}
				System.out.println();
			}
		}
	}
}