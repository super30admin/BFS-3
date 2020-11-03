// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// BFS
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
      
        if (s == null) 
            return res;
      
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
      
        //1. Put Initial string in the 
        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.remove();
                // Valid
                if (isValid(cur)) {
                    found = true;
                    res.add(cur);
                }
                // Not Valid Then Delete 
                if (!found) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') 
                            continue;

                        String newStr = cur.substring(0, j) + cur.substring(j + 1);
                        if (!visited.contains(newStr)) {
                            q.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      int count = 0;
    
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') 
            count++;
        if (c == ')' && count-- == 0) {
            return false;
        }
      }
      return count == 0;
    }
}
