//Time: O(exponential)
//Space: O(N)

//Backtracking
import java.util.*;
class validParen {
    Set<String> set;
    List<String> result;
    int maxLen;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        
        result = new ArrayList<>();
        set = new HashSet<>();
        
        backtrack(new StringBuilder(s));
        return result;
    }
    
    private void backtrack(StringBuilder sb){
        //base
        //if the string is already in set or smaller than length of the valid found so far 
        //then we do not process it
        if(set.contains(sb.toString()) || maxLen > sb.length())
            return;
        
        if(isValid(sb.toString())){
            
            if(maxLen < sb.length()){
                maxLen = sb.length();
                //in case we have been storing valid results of length 4
                //we found valid result of length 6 then we start over with the list
                result = new ArrayList<>();
            }
            result.add(sb.toString());
        }
        
        //logic
        set.add(sb.toString());
        for(int i = 0; i < sb.length(); i++){
            //action
            char c = sb.charAt(i);
            //recurse
            backtrack(sb.deleteCharAt(i));
            //backtrack
            sb.insert(i, c);
        }
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