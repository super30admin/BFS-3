// Problem Type: BFS - 3
// LeetCode - 301

// Did this code successfully run on Leetcode : yes
/**
 * Any problem you faced while coding this :
 * 
 * a. Check for validity of balanced parentheses string --> Stack is an overkill
 * b. Unable to come up with Greedy approach
 * c. missed checking for alphabets, i.e., shouldn'y remove alphabets
 */

// Your code here along with comments explaining your approach

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Algo:
 * 
 * Brute: Greedy
 * a. Able to find just one valid parentheses string, not multiple
 * 
 * Better: Exhaustive
 * a. Try all possible removals
 * In order to find min. removals --> BFS, although DFS will also work with
 * tweaks!
 * b. BFS or DFS
 * c. BFS: The moment we find a valid string, explore the complete level, and
 * don't explore other levels
 * d. DFS: If valid found, check for max. length (i.e. min. removals); else go
 * deep
 * 
 * NOTE:
 * a. Check for repeating subproblems
 * b. Instead of HashSet, we can use Tries. (Add to Trie + Check in Trie)
 */

 /**
  * TC: less than O(n * n * n!) 
  * SC: -do-
  */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses_bfs(String s) {
        List<String> valid = new ArrayList<>();
        Set<String> subproblems = new HashSet<>();

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        boolean flag = false;
        if (isValid(s)) {
            flag = true;
            valid.add(s);
        }
        while (!queue.isEmpty() && !flag) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                String poll = queue.poll();

                // explore all the possible removals
                for (int j = 0; j < poll.length(); j++) {
                    String candidate = poll;
                    char charAtJ = poll.charAt(j);
                    if (!Character.isAlphabetic(charAtJ)) {
                        candidate = poll.substring(0, j) + poll.substring(j + 1, poll.length());
                    }

                    if (isValid(candidate) && !subproblems.contains(candidate)) {
                        valid.add(candidate);
                        flag = true;
                    } else if (!flag && !subproblems.contains(candidate)) {
                        queue.offer(candidate);
                    }
                    subproblems.add(candidate);
                }
            }
        }

        return valid;
    }

    public List<String> removeInvalidParentheses_dfs(String s) {
        List<String> result = new ArrayList<>();
        Set<String> subproblems = new HashSet<>();

        helper(s, new int[1], subproblems, result);

        return result;
    }

    private void helper(String s, int[] max, Set<String> subproblems, List<String> result) {
        // base
        if (subproblems.contains(s)) {
            return;
        }
        subproblems.add(s);
        if (s.length() < max[0]) {
            return;
        }
        if (isValid(s)) {
            if (s.length() > max[0]) {
                result.clear();
                max[0] = s.length();
            }
            result.add(s);
            return;
        }

        // logic
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                continue;
            }
            String sub = s.substring(0, i) + s.substring(i + 1);
            helper(sub, max, subproblems, result);
        }
    }

    private boolean isValid(String string) {
        int count = 0;
        for (char ch : string.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}