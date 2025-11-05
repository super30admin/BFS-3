// Time Complexity : O(2*n)
// Space Complexity :  O(2*n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We perform BFS traversal by removing one parenthesis at a time
//We stop at level where all valid parenthesis found

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.add(s);
        visited.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                //check if that string is valid
                if (isValid(cur)) {
                    res.add(cur);
                    found = true;
                } else {
                    if (!found) {
                        //go to next level
                        for (int i = 0; i < cur.length(); i++) {
                            if (Character.isAlphabetic(cur.charAt(i)))
                                continue;
                            String temp = cur.substring(0, i) + cur.substring(i + 1);
                            if (!visited.contains(temp)) {
                                q.add(temp);
                                visited.add(temp);
                            }

                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(' && ch != ')')
                continue;
            if (ch == '(')
                count++;
            else if (ch == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
