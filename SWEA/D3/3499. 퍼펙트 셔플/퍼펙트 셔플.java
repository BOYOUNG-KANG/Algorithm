import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String[] prev = new String[(n+1)/2];
			String[] next = new String[(n+1)/2];
			for (int j = 0; j < n; j++) {
				if (0 <= j && j < (n+1)/2) {
					prev[j] = st.nextToken();
				} else {
					next[j-((n+1)/2)] = st.nextToken();
				}
			}
			List<String> arr = new ArrayList<>();
			for (int j = 0; j < (n+1)/2; j++) {
				arr.add(prev[j]);
				arr.add(next[j]);
			}
			
			System.out.print("#"+(i+1)+" ");
			for (String s : arr) {
				if (s != null)
					System.out.print(s+" ");
			}
            System.out.println();
		}
	}
}