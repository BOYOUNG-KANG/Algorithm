import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n]; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int maxV = -1;
			for (int j = 0; j < n-1; j++) {
				for (int k = j+1; k < n; k++) {
					boolean possible = true;
					int v = arr[j] * arr[k];
					String temp = String.valueOf(v);
					for (int l = 0; l < temp.length()-1; l++) {
						if (temp.charAt(l) > temp.charAt(l+1)) {
							possible = false;
						}
					}
					if (possible) {
						maxV = Math.max(maxV, v);
					}
				}
			}
			System.out.println("#"+(i+1)+" "+maxV);
		}
	}
}
