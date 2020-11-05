    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/remove-invalid-parentheses/
    Time Complexity for operators : o(2^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (queue and hashset)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 


    */  

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        // corner case
        if(s.length() == 0){
            result.add("");
            return result;
        }
        
        HashSet<String> hashSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        boolean found = false;
        
        
        // put initial string into hashset and queue
        hashSet.add(s);
        queue.add(s);
        
        // its time for BFS
        while(!queue.isEmpty()){
            String front = queue.poll();
            // check the validity of string. if it is valid then at that level we found the valid string in min removal
            if(isValid(front)){
                found = true;
                result.add(front);
            }
            
            // if we found it then do not add next level of string to the queue
            if(!found){
                for(int x = 0; x < front.length(); x++){
                    if(front.charAt(x) != ')' && front.charAt(x) != '('){
                        continue;
                    }
                    
                    String newString = front.substring(0,x) + front.substring(x+1, front.length());
                    
                    if(!hashSet.contains(newString)){
                        hashSet.add(newString);
                        queue.add(newString);
                    }
                }
            }
        }
        
        return result;
    }
    
    
    private boolean isValid(String s){
        int count = 0;
        
        for(int x = 0; x < s.length(); x++){
            char ch = s.charAt(x);
            
            if(ch != ')' && ch != '('){
                continue;
            }
            
            if(ch == '('){
                count += 1;
                
            }else if(ch == ')'){
                if(count == 0)
                    return false;
                
                count -= 1;
            }
        }
        
        return count == 0;
    }
}


