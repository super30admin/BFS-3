import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time complexity : O(2^n)
 * Space complexity : O(n)
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        
        if(s == null){
            return result;    
        }
        
        HashSet<String> set = new HashSet();
        set.add(s);
        Queue<String> queue = new LinkedList();
        queue.add(s);
        boolean flag = false;
        
        while(!queue.isEmpty()){
            String temp = queue.poll();
            
            if(isValid(temp)){
                flag = true;
                result.add(temp);
                continue;
            }
            
            if(!flag){
                for(int i=0; i<temp.length(); i++){
                
                    if(Character.isLetter(temp.charAt(i))){
                        continue;
                    }
                    String str = temp.substring(0, i) + temp.substring(i+1);
                    if(!set.contains(str)){
                        queue.add(str);
                        set.add(str);
                    }
                }    
            }
            
        }
        
        return result;
        
    }
    
    private boolean isValid(String str){
        int count = 0;
        
        for(char ch : str.toCharArray()){
            if(ch == '('){
                count++;
            }else if(ch == ')'){
                if(count <= 0){
                    return false;
                }
                count--;
                
            }
        }
        
        return count == 0;
    }
}