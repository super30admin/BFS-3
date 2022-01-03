// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        List<String> result=new ArrayList<>();
        
        queue.add(s);
        boolean isfound=false;
        while(!queue.isEmpty() && !isfound){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                if(isValid(curr)){
                    result.add(curr);
                    isfound=true;
                }
                
                if(!isfound){
                    for(int j=0;j<curr.length();j++){
                        if(curr.charAt(j)=='(' || curr.charAt(j)==')'){
                            String newString=curr.substring(0,j)+curr.substring(j+1,curr.length());
                            if(!set.contains(newString)){
                                queue.add(newString);
                                set.add(newString);
                            }
                        }
                    }
                }
                
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s){
        int len=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                len++;
            }else if(s.charAt(i)==')'){
                len--;
            }
            
            if(len<0){
                return false;
            }
        }
        
        return len==0;
    }
}
