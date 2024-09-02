import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String o : operations) {

            StringTokenizer st = new StringTokenizer(o);
            String operator = st.nextToken();
            Integer value = Integer.parseInt(st.nextToken());

            if (operator.equals("I")) {
                minHeap.add(value);
                maxHeap.add(value);
            } else {
                if (value == 1 && !maxHeap.isEmpty()) {
                    minHeap.remove(maxHeap.poll());
                } else if (value == -1 && !minHeap.isEmpty()) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        int min; int max;

        if (!minHeap.isEmpty()) {
            min = minHeap.poll();
        } else {
            min = 0;
        }

        if (!maxHeap.isEmpty()) {
            max = maxHeap.poll();
        } else {
            max = 0;
        }

        return new int[]{max, min};
    }
}