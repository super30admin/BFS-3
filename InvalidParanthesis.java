// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// First we need to create children were we are removing one paranthesis to make the invalidParanthesis as Valid.
// If we reach the level where the Paranthesis are valid then don't go to the next level. 
// There might be duplicate children when we are processing the strings. Maintain a set and compare them before putting in queue
// if we remove flag from the while loop then also it executes because the next level children would be invalid,
// if the previous level children were valid
import java.util.*;
public class InvalidParanthesis {
    public static void main(String args[]) {
        System.out.println(removeInvalidParentheses("()())()"));
    }
    public static List<String> removeInvalidParentheses(String s) {
     Queue<String> q = new LinkedList<>();
     Set<String> set = new HashSet<>();
     List<String> result = new ArrayList<>();
     if(s == null || s.length() == 0) return result;
     set.add(s);q.add(s);
     boolean flag = false;
     while(!q.isEmpty() ) {
         int size = q.size();
        for(int i = 0; i < size; i++) { 
        String curr = q.poll();
         if(isValid(curr)) {
             flag = true;
             result.add(curr);
         }
         else {
             if(!flag) {
                for(int j = 0; j < curr.length(); j++) {
                    if(Character.isLetter(curr.charAt(j))) continue;
                    String in = curr.substring(0,j) + curr.substring(j+ 1);
                    if(!set.contains(in)) {
                        q.add(in);set.add(in);
                    }
                }
             }
         }
    }


     }
     return result;  
    }
    private static boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) { 
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}