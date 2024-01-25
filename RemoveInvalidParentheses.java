// Time Complexity : O(2^N)
// Space Complexity : O(d) depth of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.*;

class RemoveInvalidParentheses {
    List<String> list;
    Set<String> set;

    public List<String> removeInvalidParentheses(String s) {
        list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    System.out.println(curr);
                    list.add(curr);
                    flag = true;
                } else {
                    if (!flag) {
                        int n = curr.length();
                        for (int j = 0; j < n; j++) {
                            if (Character.isAlphabetic(curr.charAt(j))) continue;
                            String currSub = curr.substring(0, j) + curr.substring(j + 1, n);
                            if (!set.contains(currSub)) {
                                q.add(currSub);
                                set.add(currSub);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) continue;
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
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();

        
        String input = "()())()";
        System.out.println(solution.removeInvalidParentheses(input));
    }
}
