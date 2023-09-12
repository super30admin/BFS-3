import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes

public class RemoveInvalidParanthesisUsingDFS {
    HashSet<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;
    }

    public void dfs(String s){
        // base
        if(s.length() < max) return;

        if(isVaild(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList<>();
            }
            result.add(s);
            return;
        }

        // logic
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))) continue;
            String babyStr = s.substring(0,i)+s.substring(i+1);
            if(!set.contains(babyStr))
            {
                dfs(babyStr);
                set.add(babyStr);
            }
        }

    }

    private boolean isVaild(String s){
        int count =0;
        for(char c: s.toCharArray()){
            if(Character.isAlphabetic(c)) continue;
            else if(c == '(')
            {
                if(count < 0) return false;
                count++;
            }else if(c == ')'){
                if(count == 0) return false;
                count --;
            }
        }
        return count == 0;
    }
}