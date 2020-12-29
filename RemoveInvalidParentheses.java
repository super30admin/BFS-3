package Dec28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class RemoveInvalidParentheses {
    
    /*
    
    Time complexity: O(2^n) in worst case but average time complexity is better compared to DFS approach solution.
    Space complexity: In worst case, O(2^n) for set + O(2^n) for queue as queue will have only those elements added to it which are unique which is checked by usage of set ~= O(2^n)
    
    Approach:
    BFS solution
    
    */
    
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> res = new ArrayList<>();
        // edge
        if (s == null ) {
            return res;
        }
        
        // logic
        Set<String> set = new HashSet<>();  // used to check if a string has already been processed since there can be duplicate strings possible by eliminating one or more parentheses
        Queue<String> queue = new LinkedList<>(); // used for BFS
        set.add(s);
        queue.add(s);
        boolean flag = false; // used to identify if a valid string has been found or not
        while (!queue.isEmpty() && !flag) {
            int qSize = queue.size(); // level order traversal needs to be done to track minimum no.of eliminations as all nodes at one level will have same count of parentheses eliminated
            for (int i = 0; i < qSize; i++) {
                String cur = queue.poll();
                // check if polled string is valid or not: if yes, add to result list and set flag to true
                if (isValid(cur)) {
                    res.add(cur);
                    flag = true;
                }
                // add next level of child nodes for current string only if we didn't find a valid string with current string, because current string has lesser count of eliminated parentheses compared to its child nodes which will have an extra one count of eliminated parentheses
                if (!flag) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (Character.isLetter(cur.charAt(j))) {
                            continue;
                        }
                        // skip the character at ith position in cur string 
                        String curChild = cur.substring(0, j) + cur.substring(j+1);
                        // add child node to BFS queue only if it has not been processed earlier, i.e. not present in set. Also, add it to set in this case.
                        if (!set.contains(curChild)) {
                            queue.add(curChild);
                            set.add(curChild);
                        }
                    }
                }
                
                
            }
        }
        
        return res;
    }
    
    public boolean isValid(String s) {
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) ==  ')') {
                if (count == 0) {
                    return false;
                } 
                else {
                    count--;
                }
            }   
        }
        
        if (count == 0) {
            return true;
        }
        
        return false;
        
    }
}
