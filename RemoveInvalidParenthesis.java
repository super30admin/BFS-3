import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity: exponential
//Space Complexity exponential

class Solution {
    HashSet<String> set;
    List<String> result;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        set = new HashSet<>();
        result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.add(s);
        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    found = true;
                    result.add(curr);
                } else if (found == false) {
                    for (int j = 0; j < curr.length(); j++) {
                        if (curr.charAt(j) >= 'a' && curr.charAt(j) <= 'z') {
                            continue;
                        }
                        String baby = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(baby)) {
                            set.add(baby);
                            q.add(baby);
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
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}