// Time Complexity : O(n^(n!))
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 BFS
    public static List<String> removeInvalidParentheses(String s) {
        // null case
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        // to store the result
        List<String> result = new ArrayList<>();
        // set for repetative problems
        Set<String> set = new HashSet<>();
        // queue for bfs traversal
        Queue<String> q = new LinkedList<>();
        // add string s inside the queue and set
        q.add(s);
        set.add(s);
        // flag to break out of the while loop
        boolean flag = false;
        // BFS traversal
        while (!q.isEmpty() && !flag) {
            // to maintain the level
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // poll current string from the q
                String curr = q.poll();
                // check if current string is valid or not
                if (isValid(curr)) {
                    // if valid mark flag to true
                    flag = true;
                    // add it inside the result
                    result.add(curr);
                } else {
                    // check flag is still false than make a childrren
                    // of the current string and add it inside the queue
                    if (!flag) {
                        for (int j = 0; j < curr.length(); j++) {
                            String subStr = curr.substring(0, j) + curr.substring(j + 1);
                            // check it inside the set to avoid duplicacy
                            if (!set.contains(subStr)) {
                                set.add(subStr);
                                q.add(subStr);
                            }
                        }
                    }
                }
            }
        }
        return result;
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