import java.util.*;

class Solution {
    static char[] alpa = new char[]{'d', 'l', 'r', 'u'};
    static int[][] list = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static String ans;
    static int n, m;
    static int[] end = new int[2];
    static int k;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        ans = "";
        this.n = n; this.m = m;
        end[0] = r; end[1] = c;
        this.k = k;
        
        dfs(0, x, y, "");
        
        if (ans.equals("")) {
            return "impossible";
        }
        
        return ans;
    }
    
    private void dfs(int index, int nowx, int nowy, String value) {
        if (!ans.equals("")) return;
        
        if (index == k && nowx == end[0] && nowy == end[1]) {
            ans = value;
            return;
        }
        if (index >= k) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int tmpx = nowx + list[d][0];
            int tmpy = nowy + list[d][1];

            if (0 < tmpx && tmpx <= n && 0 < tmpy && tmpy <= m) {
                int remainDist = Math.abs(tmpx - end[0]) + Math.abs(tmpy - end[1]);
                if (remainDist > k - (index + 1) || (k - (index + 1) - remainDist) % 2 != 0) continue;

                
                dfs(index+1, tmpx, tmpy, value + alpa[d]);
            }
        }
    }
}