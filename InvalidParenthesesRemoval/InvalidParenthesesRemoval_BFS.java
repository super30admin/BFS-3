/* Time Complexity : < O(n^n)
 *   n - length of the input String */
/* Space Complexity : O(m) 
 *   m - size of the HashSet and queue */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS

//Explore all possible strings using BFS by removing one parenthesis at a  time
//check if the string is valid and add to result if it is valid

class Solution {
    List<String> res;
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        this.res = new ArrayList<>();
        this.set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i ++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    res.add(curr);
                } else {
                    if(!flag){
                        for(int k = 0; k < curr.length(); k ++){
                            char c = curr.charAt(k);
                            if(Character.isAlphabetic(c)) continue;
                            String child = curr.substring(0, k) + curr.substring(k+1);
                            if(!set.contains(child)){
                                q.add(child);
                                set.add(child);
                            }
                        }
                    }                    
                }
            }
        }
        return res;
    }
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            } else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}