package sol;
import java.util.*;
public class RemoveInvalid {
	 HashSet<String> hs= new HashSet<>();
	    public List<String> removeInvalidParentheses(String s) {
	        
	        List<String> ans= new ArrayList<>();
	        HashSet<String> hs= new HashSet<>();
	        Queue<String> q= new LinkedList<>();
	        q.add(s);
	         
	        boolean stop=false;
	        
	        while(!q.isEmpty()&&!stop){
	     
	            int size=q.size();
	        
	            for( int j=0;j<size;j++){
	              String out=q.poll();     
	               
	            if(isvalid(out)){
	            ans.add(out);
	                stop=true;
	            }
	                
	                 for( int i=0;i<out.length();i++){
	                char c= out.charAt(i);
	                if(c=='('||c==')'){
	                    
	                    
	                String x=out.substring(0,i)+out.substring(i+1);
	                
	                    if(!hs.contains(x)){
	                    hs.add(x);
	                        q.add(x);
	                    }
	                    
	                }
	                }
	                
	                
	                
	            }
	            
	            
	           
	            
	            
	            
	            
	        }
	       // System.out.println(hs);
	    
	        
	        return ans;
	        
	        
	    }
	    
	  
	                
	    public boolean isvalid(String s){
	        int length=0;
	       
	        for(int i=0;i<s.length();i++){
	        char c=s.charAt(i);    
	            
	            if(length<0){return false;}
	            
	            if(c=='('){length++;}else if(c==')'){length--;}
	            
	            
	        }
	        if(length==0){return true;}
	        return false;
	    }
	             
}
