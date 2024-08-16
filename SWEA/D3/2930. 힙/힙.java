import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] heap;
	static int heapSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> results = new ArrayList<>();
			heap = new int[N+1];
			heapSize = 0;
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					heapPush(Integer.parseInt(st.nextToken()));
				} else {
					results.add(heapPop());
				}
			}
			
			System.out.print("#" + (i+1) + " ");
			for (int r : results) {
				if (r != 0)
					System.out.print(r + " ");
			}
			System.out.println();
		}
	}
	
	private static int heapPop() {
		int popItem = -1;
		if (heap[1] != 0) {
			popItem = heap[1];
			heap[1] = heap[heapSize];
			heap[heapSize--] = 0;
		} else {
			return popItem;
		}
		
		int p = 1; int ch = p * 2;
		if (ch + 1 <= heapSize && heap[ch] < heap[ch+1]) {
			ch++;
		}
		
		while (ch <= heapSize && heap[ch] > heap[p]) {
			int temp = heap[ch]; heap[ch] = heap[p]; heap[p] = temp;
			p = ch; ch = ch * 2;
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
		}
		
		return popItem;
	}
	private static void heapPush(int data) {
		heap[++heapSize] = data;
		
		int p = heapSize / 2;
		int ch = heapSize;
		
		if (heapSize >= 2) {
			while(ch != 1 && heap[p] < heap[ch]) {
				int temp = heap[p]; heap[p] = heap[ch]; heap[ch] = temp;
				ch = p; 
				p = ch / 2;
			}
		} 
	}
}