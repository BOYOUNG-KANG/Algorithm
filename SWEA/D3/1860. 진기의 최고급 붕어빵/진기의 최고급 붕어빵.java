import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cntPerTime = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			//정렬 후 queue에 손님 담기
			Arrays.sort(arr);
			Queue<Integer> q = new LinkedList<>();
			for (int a : arr) {
				q.add(a);
			}
			
			String answer = "Possible"; 
			int cnt = 0;
			while (!q.isEmpty()) {
				int nowCnt = (q.peek() / time) * cntPerTime - cnt;
				if (nowCnt > 0) {
					cnt++;
					q.poll();
				} else {
					answer = "Impossible";
					break;
				}
			}
			System.out.println("#"+(i+1)+" "+answer);
		}
	}
}