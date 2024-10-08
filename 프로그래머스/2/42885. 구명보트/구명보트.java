import java.util.*;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int right = people.length-1;
        for (int i = people.length-1; i >= 0; i--) {
            if (people[i] >= limit) {
                answer++;
                right = Math.min(right, i-1);
            } else {
                break;
            }
        }
        
        
        int left = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                answer++;
                left++;
                right--;
            } 
            else {
                answer++;
                right--;
            }
        }
        if (left == right) answer++;
        
        return answer;
    }
}