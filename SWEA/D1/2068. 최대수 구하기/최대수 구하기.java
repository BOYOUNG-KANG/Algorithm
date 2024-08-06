import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int max_val = 0;
			for (int j = 0; j < 10; j++) {
				int tmp = sc.nextInt();
				max_val = Math.max(max_val, tmp);
			}
			System.out.println("#"+(i+1)+" "+max_val);
		}
	}
}