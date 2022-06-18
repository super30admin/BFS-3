import java.util.*;

public class Problem1 {
    public List<String> removeInvalidParentheses(String s) {
        //BFS approach
        // TC : O(Exponential)
        // SC : O(n)
        if (s == null || s.length() == 0) return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int n = s.length();
        que.add(s);
        boolean isFound = false;

        while (!que.isEmpty() && !isFound) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                String curr = que.poll();
                if (isValidString(curr)) {
                    isFound = true;
                    if (!result.contains(curr)) {
                        result.add(curr);
                    }
                } else {
                    for (int j = 0; j < curr.length(); j++) {
                        if (Character.isLetter(curr.charAt(j))) continue;
                        String child = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(child)) {
                            que.add(child);
                            set.add(child);
                        }
                    }
                }
            }
        }
        return result;
    }

    List<String> result;
    Set<String> set;
    int max;

    public List<String> removeInvalidParentheses1(String s) {
        //DFs approach
        // TC : O(Exponential)
        // SC : O (n)

        if (s == null || s.length() == 0) return new ArrayList<String>();

        result = new ArrayList<>();
        set = new HashSet<>();
        max = 0;
        dfs(s);
        return result;
    }

    private void dfs(String s) {
        //base case
        if (set.contains(s)) return;

        //logic
        set.add(s);
        if (isValidString(s)) {
            if (max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            } else if (max == s.length()) {
                result.add(s);
            }
        } else {
            for (int j = 0; j < s.length(); j++) {
                String child = s.substring(0, j) + s.substring(j + 1);
                dfs(child);
            }
        }
    }


    private boolean isValidString(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) return false;
        }
        return count == 0;
    }
}
