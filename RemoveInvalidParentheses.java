import java.util.*;

public class RemoveInvalidParentheses {
    // TC: O(N ^ N) where N is length of String
    // SC: O(N ^ N) where N is length of String
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        List<String> res = new ArrayList<>();
        boolean answerFoundAtLevel = false;
        while (!queue.isEmpty() && !answerFoundAtLevel) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (isValid(curr)) {
                    answerFoundAtLevel = true;
                    res.add(curr);
                }
                if (!answerFoundAtLevel) {
                    for (int j = 0; j < curr.length(); j++) {
                        if (!Character.isAlphabetic(curr.charAt(j))) {
                            String neighbor = curr.substring(0, j) + curr.substring(j + 1);
                            if (!visited.contains(neighbor)) {
                                queue.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
