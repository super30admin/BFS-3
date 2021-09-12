//Time: O(exponential)
//Space: O(N)

//BFS approach
import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        
        //keep a set to avoid dublicates in result
        //we only add non-duplicate children to the set so we don't process invalids again and again
        Set<String> set = new HashSet<>();
        set.add(s);
        
        boolean found = false;
        
        while(!queue.isEmpty() && !found){
            
            //keep track of size to process one level at a time
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++){
                //we poll out one string at a time
                String curr = queue.poll();
                
                //add to result if it is valid and then move onto next string in same level
                //we don't add children of this valid string because they'll be smaller in length anyways
                if(isValid(curr)){
                    result.add(curr);
                    found = true;
                }
                else{
                    //if another valid is found in this level and curr is not valid then we don't add it or it's children because the string already found on this level is longer anyways
                    
                    if(!found){
                        for(int j = 0; j < curr.length(); j++){
                            
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0, j) + curr.substring(j + 1);
                            
                            if(!set.contains(child)){
                                queue.add(child);
                                set.add(child);
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
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                count--;
            }
            else if(s.charAt(i) == '('){
                count++;
            }
            
            if(count < 0) return false;
        }
        return count == 0;
    }
    
}