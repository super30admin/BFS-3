import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

// Time O(2^N)
// Space O(2^N)
public class RemoveInvalidParenthese {
	 public List<String> removeInvalidParentheses(String s) {
	        List<String> result = new ArrayList<>();
	         if(isValid(s)){
	            result.add(s);  
	            return result;
	         }
	          
	        Set<String> visited = new HashSet<>();
	        Queue<String> q = new LinkedList<>();
	            q.add(s);
	        boolean isValidFound = false;    
	        while(!q.isEmpty() && !isValidFound){
	            int len = q.size();
	            for(int i=0;i<len;i++){
	                String curr = q.poll();
	                int n = curr.length();
	                if(!isValid(curr)){
	                    for(int j=0;j<n;j++){
	                            String temp = curr.substring(0,j)+curr.substring(j+1);
	                            if(!visited.contains(temp)){
	                                visited.add(temp);
	                                if(isValid(temp)){
	                                isValidFound = true;
	                                result.add(temp);
	                            }else{
	                                q.add(temp);
	                            }
	                        }
	                       
	                    }
	                }
	            }
	        }
	        return result;
	    }

	    private boolean isValid(String str){
	        int count = 0;
	        for(int i=0;i<str.length();i++) {
	            char ch = str.charAt(i);
	            if(ch !='(' && ch!=')') continue;
	            
	            if(ch ==')')
	                count--;
	             else if(count < 0)
	                return false;   
	             else
	                count++;   

	        }   
	        return count ==0;
	    }
}
