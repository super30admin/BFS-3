// Time Complexity : O(n^(n!))
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 2 DFS
    // to store the result
    private static List<String> result;
    // set for repetative problems
    private static Set<String> set;
    // max for remove minimum number of parrentheses
    private static int max;

    public static List<String> removeInvalidParentheses(String s) {
        // null case
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        result = new ArrayList<>();
        set = new HashSet<>();
        max = 0;
        dfs(s);
        return result;
    }

    private static void dfs(String s) {
        // base case
        if (set.contains(s))
            return;
        if (s.length() < max)
            return;

        // main logic
        // first add string into the set
        set.add(s);
        // check if string is valid
        if (isValid(s)) {
            // if valid then
            // check if maximum is less than the string length so we are going to remove
            // smaller valid string from the result(reset the result)
            if (max < s.length()) {
                result = new ArrayList<>();
            }
            // update the max and add into the result
            max = s.length();
            result.add(s);
        } else {
            // else make a substring and run dfs on it

            for (int j = 0; j < s.length(); j++) {
                String subStr = s.substring(0, j) + s.substring(j + 1);
                dfs(subStr);
            }

        }
    }

    private static boolean isValid(String s) {
        // maintain the count and check if at any point
        // count is negative return false
        // at last check if count is not equal to zero
        // then return false
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                continue;
            if (c == '(')
                count++;
            else if (c == ')') {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(removeInvalidParentheses(s));
    }
}