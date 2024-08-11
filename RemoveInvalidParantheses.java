import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 Using DFS approach
 TC - exponential
 SC - O(N)
 */

class RemoveInvalidParantheses {
    HashSet<String> set;
    List<String> result;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() ==0)
            return new ArrayList<>();

        set = new HashSet<>();
        result = new ArrayList<>();

        dfs(s);

        return result;
    }

    private void dfs(String s) {
        //base
        if(max > s.length())
            return;

        if(set.contains(s))
            return;

        set.add(s);

        if(isValid(s)) {
            if(max < s.length()) {
                max = s.length();
                result = new ArrayList();
                result.add(s);
            }

            else if(max == s.length()) {
                result.add(s);
            }

            return;
        }

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'b')
                continue;

            dfs(s.substring(0, i) + s.substring(i+1));
        }
    }

    private boolean isValid(String curr) {
        int count =0;
        for(int i =0; i < curr.length(); i++) {
            char ch = curr.charAt(i);
            if(ch == '(') {
                count++;
            }

            else if(ch == ')') {
                count--;
                if(count < 0)
                    return false;
            }
        }

        return count == 0;
    }
}