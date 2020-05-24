//Time Complexity: O(n^3) If all babies are searched for all possible cases.
//Space Complexity: O(n^3) for Queue in Worst Case.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) return result;
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s); set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            if(!flag){
                for(int i = 0; i < curr.length(); i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String temp = curr.substring(0, i) + curr.substring(i + 1);
                    if(!set.contains(temp)){
                        set.add(temp);
                        q.add(temp);
                    }
                }
            }
        }
        return result;
    }
    
    public boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
