import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Uses DFS/backtracking to remove characters and generate all possible valid parentheses strings
 * with the minimum removals required. A HashSet avoids duplicate states, and validity is checked
 * using a stack-based balance calculation.
 *
 * Time Complexity: O(2^n * n) in the worst case due to generating/removing combinations and validation.
 * Space Complexity: O(2^n * n) for recursion stack, visited states, and result storage.
 */
public class RemoveInvalidParantheses {
        public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        Set<String> seen = new HashSet();
        int maxRemovalsAllowed = minRemovlasRequired(s);
        helper(s, seen, result, maxRemovalsAllowed);
        return result;
    }

    public void helper(String s, Set<String> seen, List<String> result, int maxRemovalsAllowed) {
        if (seen.contains(s)) {
            return;
        }
        seen.add(s);

        if (maxRemovalsAllowed == 0) {
            if (minRemovlasRequired(s) == 0) {
                result.add(s);
                return;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            helper(left + right, seen, result, maxRemovalsAllowed - 1);
        }
    }

    public int minRemovlasRequired(String s) {
        Stack<Character> stk = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty()) {
                    stk.push(c);
                } else if (stk.peek() == '(') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }

        return stk.size();
    }
    
}
