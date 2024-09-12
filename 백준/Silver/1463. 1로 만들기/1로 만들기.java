import java.util.*;

public class Main {
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		d = new int[X+1];
		for (int i = 1; i <= X; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		if (X == 1) {
			System.out.println(0);
			return;
		}
		if (X == 2) {
			System.out.println(1);
			return;
		}
		if (X == 3) {
			System.out.println(1);
			return;
		}
		d[1] = 0;
		d[2] = 1;
		d[3] = 1;
		
		for (int i = 4; i <= X; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				d[i] = Math.min(d[i/3] + 1, d[i-1] + 1);
				d[i] = Math.min(d[i/2] + 1, d[i]);
			} else if (i % 3 == 0) {
				d[i] = Math.min(d[i/3] + 1, d[i-1] + 1);
			} else if (i % 2 == 0) {
				d[i] = Math.min(d[i/2] + 1, d[i-1] + 1);
			} else {
				d[i] = d[i-1] + 1;
			}
		}
		System.out.println(d[X]);
	}
}
