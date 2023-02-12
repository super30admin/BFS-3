// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Run BFS approach, keep track of every pattern we form after removing the brackets one by one
 * Once the pattern is valid, we add it to the result list.
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null)
            return result;

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while (!q.isEmpty() && !flag) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currStr = q.poll();
                if (!isValid(currStr)) {
                    if (!flag) {
                        for (int j = 0; j < currStr.length(); j++) {
                            char c = currStr.charAt(j);
                            if (c != ')' && c != '(')
                                continue;
                            String subStr = currStr.substring(0, j) + currStr.substring(j + 1);
                            if (!set.contains(subStr)) {
                                set.add(subStr);
                                q.add(subStr);
                            }
                        }
                    }
                } else {
                    flag = true;
                    result.add(currStr);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}

// DFS

// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Run DFS approach, keep track of every pattern we form after removing the
 * brackets one by one
 * Once the pattern is valid, we add it to the result list.
 */
class Solution {
    List<String> result;
    Set<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();

        if (s == null)
            return result;

        set = new HashSet<>();
        dfs(s);
        return result;
    }

    private void dfs(String s) {
        // base
        if (s.length() < max)
            return;

        // logic

        if (isValid(s)) {
            if (s.length() != max) {
                max = s.length();
                result = new ArrayList<>();
            }

            result.add(s);
            return;
        }

        set.add(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')')
                continue;
            String child = s.substring(0, i) + s.substring(i + 1);
            if (!set.contains(child)) {
                set.add(child);
                dfs(child);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}