import java.util.*;

class Solution {
    HashSet<String> set;
    List<String> res;

    public List<String> removeInvalidParentheses(String s) {

        if (s == null || s.length() == 0)
            return new ArrayList<>();
        set = new HashSet<>();
        res = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(s);

        // start the bfs

        while (!q.isEmpty() && !flag) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {

                    res.add(curr);
                    flag = true;

                } else if (flag == false) {
                    for (int j = 0; j < curr.length(); j++) {
                        if (curr.charAt(j) >= 'a' && curr.charAt(j) <= 'z')
                            continue;
                        String baby = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(baby)) {
                            set.add(baby);
                            q.add(baby);
                        }
                    }
                }
            }
        }

        return res;

    }

    // check for balance parenthesis

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