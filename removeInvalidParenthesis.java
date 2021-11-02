// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



// **********************************************
// Time Complexity : O(exponential)
// Space Complexity : O(exponential)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BFS approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        
        while(!q.isEmpty() && !flag){
            int size = q.size();
            
            for(int j=0; j<size; j++){ // go through babies of that level
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                } else{
                    if(!flag){
                        for(int i=0; i < curr.length(); i++){
                            // what if at i'th index I have a letter
                            if(Character.isLetter(curr.charAt(i))) continue;
                            
                            String child = curr.substring(0,i) + curr.substring(i+1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }
            
        }
        
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i < s.length(); i++){
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

// ****************************************