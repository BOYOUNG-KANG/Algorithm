import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static int[] sort(int[] arr) {
		int[] count = new int[101];
		for (int j = 0; j < 100; j++) {
			count[arr[j]]++;
		}
		for (int j = 1; j < 101; j++) {
			count[j] += count[j-1];
		}
		int[] sortedArr = new int[arr.length];
		for (int j = arr.length-1; j >= 0; j--) {
			sortedArr[count[arr[j]]-1] = arr[j];
			count[arr[j]]--;
		}
		return sortedArr;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int num = 100; 
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] arr = new int[num];
			for (int j = 0; j < num; j++) {
               arr[j] = Integer.parseInt(st.nextToken());
			}
			int[] sortedArr = sort(arr);
			for (int j = 0; j < n; j++) {
				if (sortedArr[0] != sortedArr[arr.length-1]) {
					sortedArr[0]++;
					sortedArr[arr.length-1]--;
					sortedArr = sort(sortedArr);
				} else {
					break;
				}
			}
			int answer = sortedArr[arr.length-1] - sortedArr[0];
			System.out.println("#"+(i+1)+" "+answer);
		}
	}
}