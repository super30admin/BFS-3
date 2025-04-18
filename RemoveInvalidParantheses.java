import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(2^n) 
 * Space Complexity: O(2^n) 
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * BFS to find all possible solution closer to the root by removing one `(` or `)` at a time.
 */

public class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        set.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (isValid(curr)) {
                result.add(curr);
                flag = true;
            }
            if (!flag) {
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if (c >= 'a' && c <= 'z') {
                        continue;
                    }

                    String newStr = curr.substring(0, j) + curr.substring(j + 1);
                    if (!set.contains(newStr)) {
                        q.add(newStr);
                        set.add(newStr);
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
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            if (c == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
    public static void main(String[] args) {
        // Your code here
    }
}