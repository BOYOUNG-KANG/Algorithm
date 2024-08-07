class Solution {
    public static int solution(int[][] sizes) {
        int bigger = 0;
        int smaller = 0;
        
        for (int i = 0; i < sizes.length; i++) {
        	int big = Math.max(sizes[i][0], sizes[i][1]);
        	int small = Math.min(sizes[i][0], sizes[i][1]);
        	bigger = Math.max(big, bigger);
        	smaller = Math.max(small, smaller);
        }
        return bigger * smaller;
    }
}