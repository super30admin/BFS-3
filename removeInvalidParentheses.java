// Time Complexity : O(n*2^n) where n is the length of the string s
// Space Complexity : O(n) where n is the length of the string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS

class removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null) return ans;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean foundAtLevel = false;
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (isValid(curr)) {
                ans.add(curr);
                foundAtLevel = true;
            }
            if (!foundAtLevel) {
                for (int i = 0; i < curr.length(); i++) {
                    if (Character.isLetter(curr.charAt(i))) continue;
                    String temp = curr.substring(0, i) + curr.substring(i + 1);
                    if (!set.contains(temp)) {
                        q.add(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count == -1) return false;
        }
        return count == 0;
    }
}