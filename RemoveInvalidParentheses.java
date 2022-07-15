// Time Complexity : O(2^N),
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class RemoveInvalidParentheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> result = new ArrayList<String>();
            if(s == null || s.length() < 1) return result;

            int len = s.length();
            Queue<String> q = new LinkedList<>();
            q.add(s);
            boolean flag = false;
            Set<String> set = new HashSet<>();
            while(!q.isEmpty()) {
                String curr = q.poll();
                if(isValidParenthesis(curr)) {
                    result.add(curr);
                    flag = true;
                }

                if(!flag) {
                    for(int i=0; i< curr.length(); i++) {
                        char ch = curr.charAt(i);
                        if(Character.isLetter(ch)) continue;
                        String newString = curr.substring(0,i) + curr.substring(i+1);
                        if(!set.contains(newString)) {
                            q.add(newString);
                            set.add(newString);
                        }
                    }
                }
            }
            return result;
        }

        private boolean isValidParenthesis(String s) {
            int count = 0;

            for(char c : s.toCharArray()) {
                if(c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                } else {
                    continue;
                }

                if(count < 0) return false;
            }

            return count == 0;
        }
    }
}
