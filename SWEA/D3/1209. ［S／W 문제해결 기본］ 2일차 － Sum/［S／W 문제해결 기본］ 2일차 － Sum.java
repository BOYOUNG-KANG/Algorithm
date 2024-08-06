import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];

			for (int j = 0; j < 100; j++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int k = 0; k < 100; k++) {
					map[j][k] =  Integer.parseInt(st.nextToken());
				}
			}
			
			int maxVal = 0;
            int leftXVal = 0; int rightXVal = 0;
			for (int j = 0; j < 100; j++) {
				int rVal = 0; int cVal = 0; 
				
				for (int k = 0; k < 100; k++) {
					rVal += map[j][k];
					cVal += map[k][j];
					if (j == k) {
						leftXVal += map[j][k];
						rightXVal += map[j][99-k];
					}
				}
				maxVal = Math.max(maxVal, rVal);
				maxVal = Math.max(maxVal, cVal);
				maxVal = Math.max(maxVal, leftXVal);
				maxVal = Math.max(maxVal, rightXVal);
			}
			System.out.println("#"+t+" "+maxVal);
		}
	}
}