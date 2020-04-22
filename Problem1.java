// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Use BFS where a hashset and queue is used. Queue stores all the strings on onel level. Whenever, a correct string is found, the flag is turned false and the level should not go further

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new LinkedList<>();
        if (s == null) {
            return result;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean shouldGo = true;

        q.add(s);

        while (!q.isEmpty()) {
            int levelCount = q.size();

            for (int i = 0; i < levelCount; i++) {
                String current = q.poll();

                if (!visited.contains(current)) {
                    if (isValid(current)) {
                        shouldGo = false;
                        result.add(current);
                    }
                    visited.add(current);

                    if (shouldGo) {
                        for (int j = 0; j < current.length(); j++) {
                            if (Character.isLetter(current.charAt(j)))
                                continue;
                            String child = current.substring(0, j) + current.substring(j + 1);

                            q.add(child);

                        }
                    }
                }
            }

            if (!shouldGo)
                break;

        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }

        return count == 0;

    }
}