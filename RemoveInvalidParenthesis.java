// Time Complexity : O(N* 2^N)
// Space Complexity : O(2^N)
import java.util.*;
public class RemoveInvalidParenthesis {
    static List<String> removeInvalidParentheses(String s) {
        List<String> sol = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        que.offer(s);
        boolean flag = false;
        while(!que.isEmpty()) {
            int size = que.size();

            for(int i = 0; i < size; i++) {
                String str = que.poll();
                if(isValid(str)) {
                    sol.add(str);
                    flag = true;
                }
                if(flag) continue;
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String sub = str.substring(0,j) + str.substring(j+1);
                    if(!set.contains(sub)){
                        que.offer(sub);
                        set.add(sub);
                    }
                }
            }
            if(flag) break;
        }

        return sol;
    }
    private static boolean isValid(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')') {
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String  s = "(a)())()";
        System.out.println("String is: "+ s);
        System.out.println("All valid parenthesis are: " + removeInvalidParentheses(s));
    }
}
