// Time Complexity :exponential
// Space Complexity :exponential
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        if (isValid(s)) {
            result.add(s);
            return result;
        }
        // BFS
        while (!q.isEmpty()) {
            String curr = q.poll();
            // after removing element at each index,
            for (int i = 0; i < curr.length(); i++) {
                char c = curr.charAt(i);
                // we skip the letters
                if (Character.isLetter(c))
                    continue;
                String newCurr = curr.substring(0, i) + curr.substring(i + 1, curr.length());
                // if new string is valid, we'll check if i already came across same string by
                // checking set,
                // and add in result and change flag
                if (isValid(newCurr)) {
                    if (!set.contains(newCurr)) {
                        set.add(newCurr);
                        result.add(newCurr);
                        flag = true;
                    }
                }
                // if flag is true we need not add its children
                if (!set.contains(newCurr) && !flag) {
                    set.add(newCurr);
                    q.add(newCurr);
                }
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        if (s == null)
            return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                continue;
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}

// ----------------DFS--------------------------
// Time Complexity :exponential
// Space Complexity :O(n) where n is length of string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    List<String> result;
    HashSet<String> set;
    boolean flag;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        max = 0;
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;

        set = new HashSet<>();
        flag = false;
        dfs(s);

        return result;
    }

    public void dfs(String s) {
        // base case
        // if we already checked the string orlength is less than max that means we
        // already found a larger valid string
        if (s.length() < max || set.contains(s))
            return;
        // if string is valid and length is more than max, empty the list and add the
        // lement
        if (isValid(s)) {
            if (s.length() > max) {
                max = Math.max(max, s.length());
                result = new ArrayList<>();
                result.add(s);
                // if length is qual just add
            } else if (s.length() == max) {
                result.add(s);
            }
            set.add(s);

        }

        // logic
        set.add(s);
        // make next level strings by removing parenthesis in all indices one by one
        for (int i = 0; i < s.length(); i++) {
            String newCurr = s.substring(0, i) + s.substring(i + 1, s.length());
            // if()
            dfs(newCurr);
        }
    }

    public boolean isValid(String s) {
        if (s == null)
            return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                continue;
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}