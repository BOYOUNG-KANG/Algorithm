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
		
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] arr = new int[8];
			for (int j = 0; j < 8; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			while (arr[7] > 0) {
				for (int j = 1; j < 6; j++) {
					int temp = arr[0] - j;
					for (int k = 0; k < 7; k++) {
						arr[k] = arr[k+1];
					}
					if (temp > 0) {
						arr[7] = temp;
					} else {
						arr[7] = 0;
						break;
					}
				}
			}
			System.out.print("#"+n+" ");
			for (int k = 0; k < 8; k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
	}
}