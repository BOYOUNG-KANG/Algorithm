class Solution {
    static int n;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) {
		String name = "JAN";
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		n = name.length();
        answer = 0;
        int move = n-1; //원래 기본 이동 횟수
        
        //지나지 않아도 되는 부분 있는지 확인
        for (int i = 0; i < n; i++) {
            answer += changeAlpha(name.charAt(i));

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

             // 좌우 이동 중 최소 이동 횟수 계산 (양방향 고려)
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }
        	answer += move;
        return answer;
    }
	
	//숫자 바꾸기
	private static int changeAlpha(int to) {
		return Math.min(to - 'A','Z' + 1 - to);
	}
}