// Time Complexity : O(2^n) : either choose or not choose a particular character from string of length n
// Space Complexity : O(n) : elements in the queue, hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//use BFS where we need to keep track of level. This is because, if a string at particular level is valid, then it's children will be of reduced length and will be automatically invalid. SO we don't need to explore them anymore.
//keep track of nodes visisted, to avoid duplicates.

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        //list to store the result
       List<String> solution = new LinkedList<>();
        
        //base check
        if(s == null) return solution;
        
        //using BFS so we will use a queue
        Queue<String> q = new LinkedList<>();
        //add element to the queue
        q.offer(s);
        
        //set to keep track of visited nodes
        Set<String> visited = new HashSet<>();
        
        //keep track of whether next level should be visited or not. This is because if we find a valid output, then this means all other valid outputs will be of the same length. SO we don't need to explore the other output of child levels as they will be of reduced length.
        boolean shouldVisitNextLevel = true;
        
        //iterate over the queue
        while(!q.isEmpty()){
           
            //we need to keep track of level
            int level = q.size();
            
            //iterate over all the elements from that level
            for(int i=0; i<level; i++){
                String curr = q.poll();
                
                //if the string have not been visited
                if(!visited.contains(curr)){
                    //check wehther it is valid or not. If yes, then add the string to the result and mark it as visited
                    if(isValid(curr)){
                        solution.add(curr);                        
                        //you don't need to explore it's child anymore
                        shouldVisitNextLevel = false;
                    }
                    //mark the string as visited
                    visited.add(curr);
                    
                    if(shouldVisitNextLevel){//you add the child to the queue only if next level exploration is true
                        
                        //find all it's child and add to the queue
                        for(int j=0; j<curr.length(); j++){
                            //since letters can be present, we need to take care of that
                            if(!Character.isLetter(curr.charAt(j))){
                               String child = curr.substring(0,j) + curr.substring(j+1);
                            q.offer(child); 
                            }
                          
                        }                        
                    }                    
                }
            }
            
            if(shouldVisitNextLevel == false) break;
        }
        
        //return the final list of result
        return solution;
    }
    
    //separate function to check whether a particular string is valid or not
    private boolean isValid(String curr){
        int count = 0;
        for(int i=0; i<curr.length(); i++){
            char ch = curr.charAt(i);
            if(ch == '(') count++;
            if(ch == ')') count--;
            
            //if at any time the counter goes to -ve then return false
            if(count < 0) return false;
        }
        
        return count == 0;
    }
}
