// Time Complexity : 0(2^n)
// Space Complexity : 0(2^n)


class Solution {
    List<String> result;
    HashSet<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        set = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;        
    }

    private void dfs(String s) {
        if (set.contains(s) || s.length() < max) {
            return;
        }
        if (isValid(s)) {
            if (max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if (s.length() == max) {
                result.add(s);
            }
        }
        set.add(s);
        for (int j = 0; j < s.length(); j++) {
            if (Character.isLetter(s.charAt(j))) continue;
            String child = s.substring(0, j) + s.substring(j + 1);
            dfs(child);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}