// Time Complexity : O(N^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using bfs approach, process the input string level wise by removing one parantheses and check if its valid.
 * Since we are using bfs approach, we will get a valid string with minimal removals.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        boolean flag = false;

        while(!queue.isEmpty() && !flag){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String curr = queue.poll();
                int len = curr.length();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }else {
                    if(!flag){
                        for(int j=0; j<len; j++){
                            if(s.charAt(j) != ')' && s.charAt(j) != '(')
                                continue;

                            String newStr = curr.substring(0, j) + curr.substring(j+1);
                            if(!set.contains(newStr)){
                                queue.offer(newStr);
                                set.add(newStr);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String str){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch == '(')
                count++;
            else if(ch == ')')
                count--;

            if(count < 0)
                return false;
        }

        return count == 0;
    }
}
