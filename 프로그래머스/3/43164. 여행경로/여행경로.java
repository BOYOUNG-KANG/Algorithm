import java.util.*;

class Solution {
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        //tickets[i][1] 알파벳 순 정렬
        Arrays.sort(tickets, (a, b) -> {
            
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);     
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        List<String> result = dfs(tickets, "ICN", path, 0);
        System.out.println(result);
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    private List<String> dfs(String[][] tickets, String now, 
                             List<String> val, int cnt) {
        if (cnt == tickets.length) {
            return val;
        } 
        
        for (int i = 0; i < tickets.length; i++) {
                 
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                val.add(tickets[i][1]);
                
                List<String> result = dfs(tickets, tickets[i][1], val, cnt+1);
                if (result != null) return result;
                
                visited[i] = false;
                val.remove(val.size() - 1);
            }
        }
        return null;
    }
    
}