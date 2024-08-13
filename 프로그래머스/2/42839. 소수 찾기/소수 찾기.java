import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean isPrime(int number) {
        int temp = (int) Math.sqrt(number);
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= temp; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(String numbers, String s, Set<Integer> nums, boolean[] isVisited) {
         for (int i = 0; i < numbers.length(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), nums, isVisited);
                isVisited[i] = false;
            }
        }
    }
    
	public static int solution(String numbers) {
        int answer = 0;
        Set<Integer> nums = new HashSet<>();
        // 소수 : 0~거듭제곱까지 나누었을 모든 경우에 나머지가 0이 아님을 확인
	      char[] temp = numbers.toCharArray();
        int[] arr = new int[temp.length];
        boolean[] isVisited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(temp[i]);
        }
        
        dfs(numbers, "", nums, isVisited);
        
        for (int n : nums) {
            if (isPrime(n)) {
                System.out.println(n);
                answer++;
            }
        }
        return answer;
    }
}
