import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution
{
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	public static void main(String[] args) throws IOException{
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
		for (int i = 0; i < n; i++) {
			if (infix[i] == ')') {
				while (stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
			} else if (map.containsKey(infix[i])) {
				if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) >= map.get(infix[i])) {
					postfix += stack.pop();
					stack.push(infix[i]);
				} else {
					stack.push(infix[i]);
				}
			} else if ('0' <= infix[i] && infix[i] <= '9'){
				postfix += infix[i];
			} else {
				stack.push(infix[i]);
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	static int calPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (char c : postfix.toCharArray()) {
			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				if (c == '+') {
					stack.push(num1 + num2);
				} else if (c == '*') {
					stack.push(num1 * num2);
				}
			}
		}
		return stack.pop();
	}
}