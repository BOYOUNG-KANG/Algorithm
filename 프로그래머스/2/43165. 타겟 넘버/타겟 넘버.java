class Solution {
    static int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public void dfs(int[] numbers, int target, int idx, int now){
        if (idx == numbers.length) {
            if (now == target) {
                cnt++;
            } 
            return;
        }
        
        dfs(numbers, target, idx+1, now + numbers[idx]);
        dfs(numbers, target, idx+1, now - numbers[idx]);
    }
}