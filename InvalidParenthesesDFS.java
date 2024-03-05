/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n^n)
    n - length of the string
* 
* Space Complexity: O(n^n)
* 
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InvalidParenthesesDFS {
    List<String> result;

    HashSet<String> hset;

    int maxLength = 0;

    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();

        hset = new HashSet<>();

        dfs(s);

        return result;
    }

    private void dfs(String s) {
        if (hset.contains(s) || s.length() < maxLength) {
            return;
        }

        if (isValid(s) && maxLength <= s.length()) {
            if (maxLength < s.length()) {
                result = new ArrayList<>();
                maxLength = Math.max(maxLength, s.length());
            }
            result.add(s);
        }

        hset.add(s);

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (ch >= 'a' && ch <= 'z') {
                continue;
            }

            String trimmedString = s.substring(0, index) + s.substring(index + 1);

            dfs(trimmedString);
        }
    }

    private boolean isValid(String s) {
        int counter = 0;

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                counter--;
            }

            if (counter < 0) {
                return false;
            }
        }

        return counter == 0;
    }
}
