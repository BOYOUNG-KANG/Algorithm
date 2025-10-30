import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, String> parked = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        Map<Integer, Integer> totalFee = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            set.add(Integer.parseInt(record[1]));
            if (record[2].equals("IN")) {
                parked.put(Integer.parseInt(record[1]), record[0]);
            } else if (record[2].equals("OUT")) {
                int carNum = Integer.parseInt(record[1]);
                String start = parked.get(carNum);

                int inTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
                int outTime = Integer.parseInt(record[0].substring(0, 2)) * 60 + Integer.parseInt(record[0].substring(3, 5));
                int totalT = outTime - inTime;

                int prevT = totalTime.getOrDefault(carNum, 0);
                totalTime.put(carNum, prevT + totalT);
                parked.remove(carNum);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for (Integer carNum : parked.keySet()) {
            String start = parked.get(carNum);

            int inTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
            int outTime = 23 * 60 + 59;
            int totalT = outTime - inTime;

            int prevT = totalTime.getOrDefault(carNum, 0);
            totalTime.put(carNum, prevT + totalT);
        }

        for (int i = 0; i < list.size(); i++) {
            int carNum = list.get(i);

            int nowF = fees[1];
            if(totalTime.get(carNum) > fees[0]) {
                nowF += (int) Math.ceil((double) (totalTime.get(carNum) - fees[0]) / fees[2]) * fees[3];
            }
            int prev = totalFee.getOrDefault(list.get(i), 0);
            totalFee.put(list.get(i), prev + nowF);

            answer[i] = totalFee.get(list.get(i));
        }
        return answer;
    }
}