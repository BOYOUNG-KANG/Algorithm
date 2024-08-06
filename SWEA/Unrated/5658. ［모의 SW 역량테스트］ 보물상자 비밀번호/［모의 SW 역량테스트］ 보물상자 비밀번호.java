import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution
{
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String arr = br.readLine();

            Set<String> set = new TreeSet<>(Collections.reverseOrder());
            int numLength = n / 4;
            for (int l = 0; l < numLength; l++) {
                arr = arr.substring(1, n) + arr.substring(0, 1);
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    String temp = arr.substring(idx, idx + numLength);
                    set.add(temp);
                    idx += numLength;
                }
            }
            int count = 0; int answer = -1;
            for (String temp : set) {
                count++;
                if (count == k) {
                    answer = Integer.parseInt(temp, 16);
                }
            }
            System.out.println("#"+(i+1)+" "+answer);
        }
    }
}