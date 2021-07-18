package BFS3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*https://www.youtube.com/watch?v=o4Mvg_jTfJE
    
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

    Return all the possible results. You may return the answer in any order.

    Example 1:
    Input: s = "()())()"
    Output: ["(())()","()()()"]
    Example 2:
    Input: s = "(a)())()"
    Output: ["(a())()","(a)()()"]
    Example 3:
    Input: s = ")("
    Output: [""]
     

    Constraints:
    1 <= s.length <= 25
    s consists of lowercase English letters and parentheses '(' and ')'.
    There will be at most 20 parentheses in s.
https://leetcode.com/problems/remove-invalid-parentheses/
   
-------------------------------------------------------------------------------------------------------
Time complexity : O(2^N)
space complexity: O(N)
Did this code run successfully in leetcode : yes
problems faces : no*/

public class RemoveInvalidParentheses {

    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        if (s == null || s.length() == 0)
            return result;

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);

        boolean foundValidString = false;

        while (!q.isEmpty() && !foundValidString) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    foundValidString = true;
                    result.add(curr);
                }
                if (!foundValidString) {
                    for (int k = 0; k < curr.length(); k++) {
                        if (Character.isLetter(curr.charAt(k))) //this for loop is needed if we want to got level by level. Even if we remove this for loop it will work but we will be processing all the children
                            continue;
                        String child = curr.substring(0, k) + curr.substring(k + 1, curr.length());
                        if (!visited.contains(child)) {
                            q.add(child);
                            visited.add(child);
                        }
                    }
                }
            }
        }
        return result;

    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (count == 0)
                    return false;
                count--;
            } else if (c == '(') {
                count++;
            }
        }

        return count == 0;
    }

}
