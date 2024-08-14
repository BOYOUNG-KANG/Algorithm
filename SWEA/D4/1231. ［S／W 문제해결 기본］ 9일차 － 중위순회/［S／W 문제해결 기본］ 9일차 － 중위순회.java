import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static String result = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			List<String[]> tree = new ArrayList<>();
			tree.add(new String[]{});
			
			for (int j = 1; j <= n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String[] arr = new String[2];
				arr[0] = st.nextToken();
				String temp = st.nextToken();
				if (('A' <= temp.charAt(0) && temp.charAt(0) <= 'Z') || temp.charAt(0) == '_') {
					arr[1] = temp;
				}
				tree.add(arr);
			}
			result = "";
			inorder(1, n, tree);
			System.out.println("#"+(i+1)+" "+result);
		}
	}
	
	private static void inorder(int node, int n, List<String[]> tree) {
		if (node * 2 <= n) {
			inorder(node * 2, n, tree);
		}
		
		for (int j = 1; j < tree.get(node).length; j++) {
			if (tree.get(node)[1] != null) {
				result += tree.get(node)[1];
			}
		}
		
		if (node * 2 + 1 <= n) {
			inorder(node * 2 + 1, n, tree);
		}
	}
}
