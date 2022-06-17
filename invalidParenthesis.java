/*
Problem: https://leetcode.com/problems/remove-invalid-parentheses/
TC: O(exponential)
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        HashSet<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        seen.add(s);
        boolean foundValidString = false;
        
        while (!queue.isEmpty() && !foundValidString) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String currentString = queue.poll();
                
                if (isValid(currentString)) {
                    result.add(currentString);
                    foundValidString = true;
                } else {
                    if (!foundValidString) {
                        for (int j = 0; j < currentString.length(); ++j) {
                            if (Character.isLetter(currentString.charAt(j)))
                                continue;
                            
                            String newString = currentString.substring(0, j) + currentString.substring(j + 1);
                            if (!seen.contains(newString)) {
                                seen.add(newString);
                                queue.offer(newString);
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int brackets = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++brackets;
            } else if(s.charAt(i) == ')') {
                --brackets;
                if (brackets < 0)
                    return false;
            }
        }
        return brackets == 0;
    }
}