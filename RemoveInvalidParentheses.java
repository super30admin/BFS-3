// Time Complexity : O((N^2)(2^N)) --> 2^N : all possible strings by removing any number of chars; N^2 : N:substring copy, N: checking the valid parnethesis 
// Space Complexity : O(2^N) --> HashSet adds all possible strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 BFS
 1. DFS is possible solution
 2. But we will be iterating through all strings not just minimum removal, hence we do BFS
 3. Use HashSet, as we get same child strings sometimes.
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null) return result;
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add(s); hs.add(s);
        boolean flag = false;
        
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                result.add(curr);
                flag = true;
            }
            if(!flag){
                for(int i=0; i<curr.length(); i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String child = curr.substring(0,i) + curr.substring(i+1);
                    if(!hs.contains(child)){
                        q.add(child); hs.add(child);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                 if(count == 0) return false;
                 else count--;        
            }
            else continue;
        }
        if(count == 0) return true;
        else return false;
    }
}