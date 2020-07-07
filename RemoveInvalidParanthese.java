// Time Complexity : O(2 ^ n)
// Space Complexity : O(2 ^ n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class RemoveInvalidParanthese {
    public List<String> removeInvalidParentheses(String s) {
        // Using BFS Time : O(2 ^ n)
        if(s == null){
            return null;
        }
        List<String> result = new ArrayList<>();

        // Queue for BFS
        Queue<String> q = new LinkedList<>();

        // Set for avoiding repeated String combinatins in result
        Set<String> set = new HashSet<>();

        // flag to check if
        boolean flag = false;

        q.add(s);

        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }

            if(!flag){
                for(int i = 0; i < curr.length(); i++){
                    if(Character.isLetter(curr.charAt(i))){
                        continue;
                    }
                    // delete ith character from string
                    String child = curr.substring(0,i) + curr.substring(i+1);

                    if(!set.contains(child)){
                        set.add(child);
                        q.add(child);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            } else if( c == ')'){
                if(count == 0){
                    return false;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }
}
