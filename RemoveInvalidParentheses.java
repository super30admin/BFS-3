// Time Complexity : O(n^2) * 2^n --> where n is the length of the input string
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode (301): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        // edge case
        if (s == null) return result;
        
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s); set.add(s);
        boolean flag = false;
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (isValid(curr)) {
                result.add(curr);
                flag = true;
            }
            if (!flag) {
                for (int i = 0; i < curr.length(); i++) {
                    if (Character.isLetter(curr.charAt(i))) continue;
                    String child = curr.substring(0, i) + curr.substring(i+1);
                    if (!set.contains(child)) {
                        q.add(child); set.add(child);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}