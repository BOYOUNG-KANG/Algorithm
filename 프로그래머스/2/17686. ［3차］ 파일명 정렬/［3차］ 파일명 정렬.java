import java.util.*;

class File {
    String head;
    int number;
    String file;
    
    public File(String head, int number,  String file) {
        this.head = head;
        this.number = number;
        this.file = file;
    }
}
// 1. 대소문자 구분 않고 문자열 비교
// 2. 숫자 앞 0 무시하고 숫자 정렬
// 3. 입력 순서 유지
class Solution {
    public String[] solution(String[] files) {
        File[] fileList = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int start = 0;
            
            while (!Character.isDigit(file.charAt(start))) {
                start++;
            }
            
            int end = start;
            
            while (end < file.length() 
                   && Character.isDigit(file.charAt(end))
                  && 5 > end - start) {
                end++;
            }
            
            String head = file.substring(0, start);
            int number = Integer.parseInt(file.substring(start, end));
            fileList[i] = new File(head, number, file);
        }
        
        Arrays.sort(fileList, (a, b) -> {
            int cmp = a.head.compareToIgnoreCase(b.head);
            if (cmp != 0) {
                return cmp;
            }
            
            return Integer.compare(a.number, b.number);
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileList[i].file;
        }
        return answer;
    }
}