class Solution {
    static boolean solution(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] =='(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        if (left > 0) {
            return false;
        }
        return true;
    }
}