import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			int num = sc.nextInt();
			int m = sc.nextInt();
			int total = num;
			for (int j = 1; j < m; j++) {
				total *= num;
			}
			System.out.println("#"+(i+1)+" "+total);
		}
	}
}