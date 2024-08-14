import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		for (int i = 0; i < 10; i++){
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> words = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				words.add(Integer.parseInt(st.nextToken()));
			}
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String[] commands = new String[m];
			for (int j = 0; j < m; j++) {
				char temp = st.nextToken().charAt(0);
				if (temp == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int[] arr = new int[y];
					for (int k = 0; k < y; k++) {
						arr[k] = Integer.parseInt(st.nextToken());
					}
					
					int k = 0; int l = x;
					while (k < y) {
						words.add(l, arr[k]);
						k++; l++;
					}
				} else if (temp == 'D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					int k = 0;
					while (k < y) {
						words.remove(x);
						k++;
					}
				} else if (temp == 'A') {
					int y = Integer.parseInt(st.nextToken());
					int[] arr = new int[y];
					for (int k = 0; k < y; k++) {
						int t = Integer.parseInt(st.nextToken());
						words.add(t);
					}
				}
			}
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < 10; j++) {
				System.out.print(words.get(j)+" ");
			}
			System.out.println();
		}
	}
}