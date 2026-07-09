import java.util.*;

class Solution {
    static int[][] map;
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public int solution(int[][] board, int[] moves) {
        map = new int[board.length][board[0].length];
        int cnt = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;
            
            int nowy = 0;
            int now = board[nowy][move];
            for (int y = 0; y < board.length; y++) {
                if (board[y][move] != 0) {
                    now = board[y][move];
                    board[y][move] = 0;
                    
                    if (!stack.isEmpty() && stack.peek() == now) {
                        stack.pop();
                        cnt += 2;
                    } else {
                        stack.push(now);
                    }
                    
                    break;
                }
            }
        }
        
        return cnt;
    }
}