/* Time Complexity : < O(n^n)
 *   n - length of the input String */
/* Space Complexity : O(m) 
 *   m - size of the HashSet */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
//DFS

//Explore all possible strings using DFS by removing one parenthesis at a  time
//check if the string is valid and add to result if it is valid, 
//while making sure that the string added to the result has the max length(longest valid string)

class Solution {
    List<String> res;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        this.res = new ArrayList<>();
        this.set = new HashSet<>();
        dfs(s);
        return res;
    }
    private void dfs(String s){
        //base case
        if(s.length() < max) return;
        if(isValid(s)){
            if(s.length() > max){
                res = new ArrayList<>();
                max = s.length();
            }
            res.add(s);
        }
        //logic
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            String child = s.substring(0, i) + s.substring(i+1);
            if(!set.contains(child)){
                set.add(child);
                dfs(child);
            }
        }
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