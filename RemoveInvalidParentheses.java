// Time Complexity : O(n!) where n is the length of the string 
// Space Complexity : O(n!) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a queue, hashset for computation and list for result
// Add current String to queue and do level order traversal
// We will remove 1 character from the string at each level
// When we see a valid string, that level would have all the result strings
// We will explore all the strings at the level and add the valids to result
// Now we will return the result list.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList();
        Queue<String> q = new LinkedList();
        HashSet<String> hs = new HashSet();
        q.add(s);
        while(!q.isEmpty() && result.size() == 0){
            int n = q.size();
            for(int i = 0; i < n; i++){
                String cur = q.poll();
                if(isValidStr(cur)){
                    result.add(cur);
                }
                else{
                    for(int j = 0; j < cur.length(); j++){
                        String str = cur.substring(0,j) + ((j - 1 > cur.length())? "":cur.substring(j+1));
                        if(!hs.contains(str)){
                            hs.add(str);
                            q.add(str);
                        }
                    }
                }
            }
            hs.clear();
        }
        return result;
    }
    boolean isValidStr(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            if(s.charAt(i) == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}