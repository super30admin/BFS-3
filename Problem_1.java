// Time Complexity : O(n^n)
// Space Complexity : O(n)  -- n is length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//DFS method, removing 1 parenthesis on each level from 0 to n positions and checking if the resulting string
//has valid parenthesis. Once valid string found, returning all such string from that level.

//301. Remove Invalid Parentheses

class Solution {
    HashSet<String> set;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        set = new HashSet<>();
        result = new ArrayList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }
                else if(flag == false){
                    for(int j = 0; j < curr.length(); j++){
                        if(curr.charAt(j) >= 'a' && curr.charAt(j) <= 'z') continue;
                        String a = curr.substring(0, j) + curr.substring(j + 1);
                        if(!set.contains(a)){
                            set.add(a);
                            q.add(a);
                        }
                    }
                }
                
                
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}

