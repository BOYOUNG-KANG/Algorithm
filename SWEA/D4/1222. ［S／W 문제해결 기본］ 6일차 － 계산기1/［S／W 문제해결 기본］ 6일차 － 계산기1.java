import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			
			String postfix = convertToPostfix(arr, n);
			int total = calPostfix(postfix);
			System.out.println("#"+(i+1)+" "+total);
		}
	}
	static String convertToPostfix(char[] infix, int n) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		for (int j = 0; j < n; j++) {
			if ('0' <= infix[j] && infix[j] <= '9') {
				postfix += infix[j];
			} else {
				stack.push(infix[j]);
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	static int calPostfix(String postfix) {
		int result = 0;
		for (int j = 0; j < postfix.length(); j++) {
			if ('0' <= postfix.charAt(j) && postfix.charAt(j) <= '9') {
				result += (postfix.charAt(j) -'0');
			} 
		}
		return result;
	}
}