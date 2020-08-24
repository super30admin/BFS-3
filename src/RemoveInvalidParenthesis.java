// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 *brute force is - try removing one char at a time and check each combination for validity using recursion
 *can be done by both dfs and bfs.
 *
 * using bfs gives more optimized solution, if valid string found at one level then we do not have to go to next level
 * this still have exponential time but more optimized. 
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        
        if(s == null) return res;
        
        Queue<String> q = new LinkedList<>(); //for bfs
        Set<String> set = new HashSet<>(); // set to find out if string was alredy processed
        
        q.add(s);
        set.add(s);
        boolean flag = false;
        
        while(!q.isEmpty()) {
          String curr = q.poll();
          
          //if curr is valid, add it to result
          if(isValid(curr)) {
              flag = true;
              res.add(curr);
          }
          
          //if no valid string found yet, then add next level children to queue
          //this ensures, we do not go down to next levels if valid strings found at this level, optimal perf for avg case
          if(!flag){
              for(int i=0; i<curr.length(); i++) {
                  //if current char is letter, skip it 
                  if(Character.isLetter(curr.charAt(i))) continue;
                  
                  //removing ith char and putting that string into queue for processing
                  String child = curr.substring(0,i) + curr.substring(i+1);
                  
                  //if child string not processed already
                  if(!set.contains(child)){
                      q.add(child);
                      set.add(child);
                  }
                  
              }
          }    
        }
        
        return res;
    }
    
    //constant space, o(n) parenthesis validity using count
    private boolean isValid(String s) {
        int count = 0;
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }
        
        return count == 0;
    }
}