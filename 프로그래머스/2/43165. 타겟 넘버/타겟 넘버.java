class Solution {
    static int[] nums;
	static int t;
	static int cnt;
    public static int solution(int[] numbers, int target) {
        t = target;
        nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
        	nums[i] = numbers[i];
        }
        cnt = 0;
        combination(0, 0);
        return cnt;
    }
	public static void combination(int idx, int sum) {
		if (idx == nums.length) {
			if (sum == t) cnt++;
			return;
		}
		combination(idx+1, sum+nums[idx]);
		combination(idx+1, sum-nums[idx]);
	}
}