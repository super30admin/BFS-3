// This Solution worked on LeetCode
// Time Complexity
// Space Complexity

//BFS Solution to check at each level if valid paranthesis string is found. Check the next level only if valid paranthesis string is not found at the current level by use of flag. Continue checking other strings at the same level if flag is true so that same length strings can be output.


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //Edge Case
        List<String> result = new ArrayList<>();
        if(s== null)    return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            if(!flag){
                for(int i=0;i < curr.length();i++){
                    if(Character.isLetter(curr.charAt(i)))  continue;
                    String temp = curr.substring(0,i) + curr.substring(i+1);
                    if(!set.contains(temp)){
                        set.add(temp);
                        q.add(temp);
                    }                      
                }
            }
            
        }
        return result;
        
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(')    count++;
            else if(c == ')'){
                if(count ==0)   return false;
                count--;
            }
        }
        return count==0;
    }
}
