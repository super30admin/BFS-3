// TC: O(2 ^ n)
// SC: O(2 ^ n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        set.add(s);
        boolean found = false;

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }

            // Only generate next states if no valid string has been found at this level.
            if (!found) {
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    // Skip non-parenthesis characters.
                    if (Character.isAlphabetic(c)) continue;

                    String next = curr.substring(0, j) + curr.substring(j + 1);
                    if (!set.contains(next)) {
                        q.add(next);
                        set.add(next);
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
            if (Character.isAlphabetic(c)) continue;
            if (c == '(') {
                count++;
            } else {  // Assume character is ')'
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
