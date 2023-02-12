// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null)
            return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String currStr =  q.poll();
                if(!isValid(currStr)){
                    if(!flag){
                        for(int j = 0; j < currStr.length(); j++){
                            char c = currStr.charAt(j);
                            if(c != ')' && c != '(')
                                continue;
                            String child = currStr.substring(0, j) + currStr.substring(j + 1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                } else {
                    flag = true;
                    result.add(currStr);
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                count++;
            else if(c == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}