// Problem 301. Remove Invalid Parentheses
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean flag = false;
        // BFS traversal
        while (!q.isEmpty() && !flag) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String curr = q.poll();
                if (isBalanced(curr)) {
                    result.add(curr);
                    flag = true;
                }
                if (!flag) {
                    for (int i = 0; i < curr.length(); i++) {
                        char ch = curr.charAt(i);
                        if (Character.isAlphabetic(ch)) continue;
                        String child = curr.substring(0, i) + curr.substring(i + 1);
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

    // Helper function to check if a string has balanced parentheses
    private boolean isBalanced(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) continue;
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
