// Time Complexity : O(2^ N*N)
// Space Complexity : O(2^ N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: The function aims to find and return a list of valid parentheses expressions from the given input string while removing the minimum number of parentheses. It uses BFS to explore different possibilities of removing parentheses and maintains a set to track visited states, ensuring uniqueness. The isValid helper function checks the validity of parentheses count, and the algorithm has an exponential time and space complexity, O(2^n), due to the nature of exploring all possible combinations.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        // result.add("");
        boolean flag = false;
        q.add(s);
        set.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                System.out.println(curr);
                if (isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else {
                    if (!flag) {
                        // make babies of it
                        for (int j = 0; j < curr.length(); j++) {
                            char c = curr.charAt(j);
                            if (Character.isAlphabetic(c))
                                continue;
                            String child = curr.substring(0, j) + curr.substring(j + 1);
                            if (!set.contains(child)) {
                                q.add(child);
                                set.add(child);
                            }
                        }
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
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        InvalidParantheses obj = new InvalidParantheses();

        String input = "()())()";
        List<String> result = obj.removeInvalidParentheses(input);

        System.out.println("Valid Parentheses:");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
