// Time Complexity: O(N * N)
// Space Complexity: O(N) -> Stack space
class Solution {
    int max;
    List<String> result;
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        result = new ArrayList<>();
        result.add("");
        set = new HashSet<>();
        dfs(s); // Initiate recursion
        return result;
    }

    private void dfs (String s) {
        // base case
        if(set.contains(s)) return;
        if (s == null || s.length() == 0) return;

        // logic
        set.add(s);
        if (isValid(s) && s.length() > max) {
            max = s.length();
            result = new ArrayList<>();
            result.add(s);
            return;
        } else if (isValid(s) && s.length() == max) {
            result.add(s);
            return;
        } else {
            for (int i=0; i < s.length(); i++) {
                // find substrings with the ith char removed
                // and call dfs recursively
                String baby = s.substring(0, i) + s.substring(i+1);
                dfs(baby);
            }
        }
    }

    private boolean isValid(String s) {
        // checks if the parenthesis are valid or not
        int count = 0;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }

        if (count == 0) return true;
        return false;
    }
}