class Solution {
    //앞에서 젤 큰 숫자부터 넣어주는 방식으로 처리
	public static String solution(String number, int k) {
		StringBuilder result = new StringBuilder();
		int idx = 0;
		
		for (int i = 0; i < number.length()-k; i++) {
			char max = '0';
			for (int j = idx; j <= k+i; j++) {
				if (number.charAt(j) > max) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			result.append(max);
		}
		return result.toString();
    }
}