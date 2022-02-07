// Time Complexity : O(exponential)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use bfs to solve this
// we create hashset for marking visited strings
// then we ccheck if the string is valid 
// if not we remove one and try to check if thats valid
class Solution {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            if (s == null || s.length() == 0)
                return new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            List<String> result = new ArrayList<>();
            boolean found = false;
            q.add(s);
            set.add(s);
            while (!q.isEmpty()) {
                String curr = q.poll();
                if (isValid(curr)) {
                    found = true;
                    result.add(curr);
                } else if (found == false) {
                    for (int j = 0; j < curr.length(); j++) {
                        if (Character.isLetter(curr.charAt(j)))
                            continue;
                        String sub = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(sub)) {
                            set.add(sub);
                            q.add(sub);
                        }
                    }

                }
            }
            return result;

        }

        public boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(')
                    count++;
                else if (c == ')')
                    count--;
                else
                    continue;
                if (count < 0)
                    return false;
            }
            return count == 0;
        }
    }
}

// Time Complexity : O(exponential)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use dfs to solve this
// we create hashset for marking visited strings
// then we ccheck if the string is valid recursively
// we make use of max variable

class Solution {

    HashSet<String> set;
    List<String> result;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        result = new ArrayList<>();
        set = new HashSet<>();
        dfs(s);
        return result;

    }

    public void dfs(String s) {
        if (set.contains(s) || s.length() < max)
            return;
        set.add(s);
        if (isValid(s)) {
            if (max < s.length()) {
                max = s.length();
                result = new ArrayList();
                result.add(s);
            } else if (s.length() == max) {
                result.add(s);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                continue;
            String sub = s.substring(0, i) + s.substring(i + 1);
            dfs(sub);
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            else
                continue;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}