// Time Complexity : 2^N (Worst Case)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    Set<String> set = new HashSet<>();

    public void dfs(String s, int index, int left_rem, int right_rem, int leftCount, int rightCount, StringBuilder expr) {

        if (index == s.length()) {
            // checking if its the valid parenthesis with min removals
            if(left_rem == 0 && right_rem == 0) {
                set.add(expr.toString());
            }
        } else {
            char c = s.charAt(index);
            int length = expr.length();

            // we will either choose or not-choose the char
            // Not choose - discard
            // only discard if left_rem > 0 || right_rem > 0 - then there is scope for min discard
            if ((c == '(' && left_rem > 0) || (c == ')' && right_rem > 0)) {
                // discard the char and move
                dfs(s, index + 1,
                        left_rem - (c == '(' ? 1 : 0),
                        right_rem - (c == ')' ? 1 : 0),
                        leftCount, rightCount, expr);
            }

            // choose
            expr.append(c);

            if (c != '(' && c != ')') {
                dfs(s, index + 1, left_rem, right_rem, leftCount, rightCount, expr);
            } else if (c == '(') {
                dfs(s, index + 1, left_rem, right_rem, leftCount + 1, rightCount, expr);
            }
            // optimization - only check if rightCount < leftCount
            else if (rightCount < leftCount) {
                dfs(s, index + 1, left_rem, right_rem, leftCount, rightCount + 1, expr);
            }

            // delete for backtracking
            expr.deleteCharAt(length);
        }


    }

    public List<String> removeInvalidParentheses(String s) {

        // Get the left and right count to be deleted
        // This count will remain constant for all the valid parenthesis and will be minimum
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        dfs(s,0,left,right,0,0,new StringBuilder());

        return new ArrayList<>(set);
    }
}