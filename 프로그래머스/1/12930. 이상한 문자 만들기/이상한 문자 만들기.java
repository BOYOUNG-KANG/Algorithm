class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char alpa = s.charAt(i);
            if (alpa != ' ') {
                if (idx % 2 == 0) {
                    answer += Character.toUpperCase(alpa);
                    idx++;
                } else {
                    answer += Character.toLowerCase(alpa);
                    idx++;
                }
            } else {
                answer += ' ';
                idx = 0;
            }
        }
        return answer;
    }
}