import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//time complexity is exonential o(2^n) at every stage needs to make 2 decision select parenthesis or not to select 
//for making valid expression with less no of removal count of parenthesis.
//space complexity is  0(n)
//Approach
//add original expression into queue . 
//poll from queue and chec if its valid. if valid make flag to true and add valid expression into resultant list.
// if not valid  and flag is false then check again it's pattern and add into queue . if flag is false poll next element from queue.
//process goes on till queue becomes empty . at the end return result.


public class RemoveInvalidParenthesisBFS {
	    public List<String> removeInvalidParentheses(String s) {
	        if(s== null) return null;
	        Queue<String> q = new LinkedList<>();
	        List<String> result = new ArrayList<>();
	        HashSet<String> set = new HashSet<>();
	        q.add(s);
	        boolean flag = false;
	        while(!q.isEmpty()){
	            s= q.poll();
	            if(isValid(s)){
	                result.add(s);
	                flag = true;
	            }
	            if(flag) continue; //if we got valid expression then flag become true so we got combination with removal parethesis count as minimum so no need to remove further parenthesis.
	            // just continue and check next combination of expression  in queue.
	            for(int i=0;i<s.length();i++){
	                String expression = s.substring(0,i) + s.substring(i+1);
	                if(Character.isLetter(s.charAt(i))) continue;
	                if(!set.contains(expression)){
	                    q.add(expression);
	                    set.add(expression);
	                }
	                
	            }
	        }
	        return result;
	    }
	    public boolean isValid(String s){
	        int count =0;
	        for(int i=0;i<s.length();i++){
	             if(s.charAt(i)=='(') count++;
	            else if (s.charAt(i)==')'){
	                if(count ==0) return false;
	                count--;
	            }
	        }
	       return count ==0;
	    }
}
