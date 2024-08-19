/*
    LC - 301. Remove Invalid Parentheses
    TC - TC - O(2^n)
*/

class Solution {
    List<String> result;
    HashSet<String> visited;
    int max = 0;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        visited = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;
    }
    public void dfs(String s) {
        // base
        if(s.length() < max) {
            return;
        }

        if(visited.contains(s)) {
            return;
        }
        visited.add(s);
        // logic
        if(isValid(s)) {
            if(max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            } else if(max == s.length()) {
                result.add(s);
            }
            return;
        }
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c<='z') {
                continue;
            }
            String child = s.substring(0, i) + s.substring(i + 1);
            dfs(child);
        }
    }
    public boolean isValid(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}