import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(tmp, 0);
            if (count == 0) {
                map.put(tmp, 1);
                list.add(tmp);
            } else {
                map.put(tmp, count+1);
            }
        }

        list.sort((o1, o2) -> {
            int ele1 = map.get(o1);
            int ele2 = map.get(o2);
            if (ele1 == ele2) {
                return 0;
            } else {
                return ele2 - ele1;
            }
        });

        for (Integer ele : list) {
            int count = map.get(ele);
            for (int i = 0; i < count; i++) {
                System.out.print(ele + " ");
            }
        }
    }
}
