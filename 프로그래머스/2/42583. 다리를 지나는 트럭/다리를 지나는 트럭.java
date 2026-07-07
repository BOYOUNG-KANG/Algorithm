import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>(); // 트럭 무게, 들어간 시간
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int prev = 0;
        int time = 0;
        int idx = 0;
        while(idx <= truck_weights.length - 1) {
            time++;
            
            if (!queue.isEmpty()) {
                int[] truck = queue.peek();
                if (time - truck[1] >= bridge_length) { // 시간 지난 트럭 빠져나옴
                    System.out.println("11"+Arrays.toString(truck));
                    queue.poll();
                    prev -= truck[0];
                }
            }
            
            if (prev + truck_weights[idx] <= weight) { //다리 건널 수 있음
                queue.offer(new int[]{truck_weights[idx], time});
                prev += truck_weights[idx];
                idx++;
            }
        }
        
        int tmptotal = time;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            time = tmp[1] + bridge_length;
        }
        return time;
    }
}