import java.util.*;

public class InvalidParentheses {
    // Time Complexity : O(n ^ n) where n is the length of the String s
    // Space Complexity :O(n ^n) as the visited set could contain all the children of s in the worst case
    // Did this code successfully run on Leetcode :yes
    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> result = new ArrayList<>();
        boolean flag = false;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);

        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }else{
                    if(!flag){
                        //try removing each char
                        for(int j=0; j<curr.length(); j++){
                            if(Character.isAlphabetic(s.charAt(j))) continue;
                            String child = curr.substring(0, j) + curr.substring(j+1);
                            if(!visited.contains(child)){
                                q.add(child);
                                visited.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    //DSF
    // Time Complexity : O(n ^ n) where n is the length of the String s
    // Space Complexity :O(n ^n) as the visited set could contain all the children of s in the worst case
    // Did this code successfully run on Leetcode :yes
    private int maxLength;
    private HashSet<String> visited;
    private List<String> result;
    public List<String> removeInvalidParenthesesDFS(String s){
        this.visited = new HashSet<>();
        this.result = new ArrayList<>();
        dfs(s);
        return result;
    }

    private void dfs(String s){
        //base
        if(s.length() < maxLength){
            return;
        }

        if(isValid(s)){
            if(s.length() > maxLength){
                maxLength = s.length();
                result = new ArrayList<>();
            }
            result.add(s);
            visited.add(s);
            return;
        }

        //logic
        for(int i =0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            String child = s.substring(0, i) + s.substring(i+1);
            if(!visited.contains(child)){
                visited.add(child);
                dfs(child);
            }
        }
    }


    private boolean isValid(String s){
        int len = s.length();
        int count =0;
        for(int i=0; i<len; i++){
            Character c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                continue;
            }
            else if(c == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
}
