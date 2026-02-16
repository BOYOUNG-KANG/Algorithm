import java.util.*;

class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        for (String[] place : places) {
            answer[idx++] = check(place)? 1 : 0;
        }
        return answer;
    }
    private boolean check(String[] place){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    
                     for (int y = 0; y < 5; y++) {
                        for (int x = 0; x < 5; x++) {
                            if ((i != y || j != x) && place[y].charAt(x) == 'P') {
                                int dist = Math.abs(i - y) + Math.abs(j - x);
                                
                                if (dist <= 2) {
                                    if (dist == 1) return false;
                                    
                                    if (i == y) {
                                        if (place[y].charAt((j+x)/2) != 'X') {
                                            return false;
                                        }
                                    } else if (j == x) {
                                        if (place[(y+i)/2].charAt(x) != 'X') {
                                            return false;
                                        }
                                    } else {
                                        if (!(place[y].charAt(j) == 'X' 
                                            && place[i].charAt(x) == 'X')) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                     }
                }
            }
        }
        return true;
    }
}