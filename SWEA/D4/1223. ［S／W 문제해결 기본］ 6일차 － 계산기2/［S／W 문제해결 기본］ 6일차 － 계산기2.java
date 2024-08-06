import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
	static Map<Character, Integer> map = new HashMap<>();
    
	static {
        map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
    }
    
	static String convertToPostfix(char[] infix, int n) {
		Stack<Character> stack = new Stack<>();
		String temp = "";
		for (int j = 0; j < n; j++) {
			if (map.get(infix[j]) != null && map.get(infix[j]) == 2) {
				stack.push(infix[j]);
			} else {
				temp += infix[j];
				while (!stack.isEmpty()) {
					temp += stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			temp += stack.pop();
		}
		String postfix ="";
		for (char c : temp.toCharArray()) {
			if (map.get(c) != null && map.get(c) == 1) {
				while (!stack.isEmpty()) {
					postfix += stack.pop();
				}
				stack.push(c);
			} else {
				postfix += c;
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	static int calPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			if ('0' <= postfix.charAt(i) && postfix.charAt(i) <= '9') {
				stack.push(postfix.charAt(i) - '0');
			} else if (postfix.charAt(i) == '+'){
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = num2 + num1;
				stack.push(result);
			} else if (postfix.charAt(i) == '*'){
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = num2 * num1;
				stack.push(result);
			}
		}
		return stack.pop();
	}
}