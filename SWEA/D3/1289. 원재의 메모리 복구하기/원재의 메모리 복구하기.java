import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			char[] arr = br.readLine().toCharArray();
			int total = 0;
			for (int j = arr.length - 1; j > 0; j--) {
				if (arr[j] != arr[j-1]) {
					total++;
				}
			}
			if (arr[0] == '1') {
				total++;
			}
			System.out.println("#"+(i+1)+" "+total);
		}
	}
}
