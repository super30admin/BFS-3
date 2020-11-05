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
                    A) If String is null then add "" to the retult list and return it. (This is the corner case).
                    B) Now create hasmap and queue. Hashmap to  maintain already clauclated strings. Add string to 
                       hashmaop and queue.
                    C) Now.  do the BFS traversal, Poll the element from the queue.
                    D) Check the validtiy of the sting, if it is valid then add to result and make found to true
                       found will avoud further traversal of levels.
                    E) if not found, then remove each characters one by one and make a string of it and addto hashset and 
                       Queue only if it not part of hashset initially.
                    F) The validity of the string is calculated by isValid function. Just m,maintain the counter for opening and 
                       closing brackets. If CLosing found when count== 0 then return false. At the end return count == 0;
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


