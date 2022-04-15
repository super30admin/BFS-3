//  Time Complexity: O(2^n)
//  Space Complexity: O(n)

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        set.add(s);

        boolean flag = false;

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                flag = true;
                result.add(cur);
            }
            else {
                if (!flag) {
                    for (int j = 0; j < cur.length(); ++j) {
                        if (Character.isLetter(cur.charAt(j))) {
                            continue;
                        }

                        String child = cur.substring(0, j) + cur.substring(j+1);

                        if (!set.contains(child)) {
                            queue.offer(child);
                            set.add(child);
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLetter(s.charAt(i))) {
                continue;
            }
            else if (c == '(') {
                count++;
            }
            else {
                if (count == 0) {
                    return false;
                }

                count--;
            }
        }

        return count == 0;
    }
}
