class Solution {
    List<String> res;
    HashSet<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        set = new HashSet<>();
        res = new ArrayList<>();

        dfs(s);
        return res;

    }

    private void dfs(String s) {
        // base

        if (s.length() < max) {
            return;
        }

        // logic
        if (isValid(s)) {
            if (s.length() > max) {
                max = s.length();
                res = new ArrayList<>();
                res.add(s);
            } else if (max == s.length()) {
                res.add(s);
            }

        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c >= 'a' && c <= 'z')
                    continue;
                String baby = s.substring(0, i) + s.substring(i + 1);
                if (!set.contains(baby)) {
                    set.add(baby);
                    dfs(baby);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0)
                    return false;

            }
        }

        return count == 0;
    }
}