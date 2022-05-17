import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(n^n)
//Space Complexity : O(n)
public class RemoveInvalidParentheses {		
	/**Approach: BFS**/
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(s);
        set.add(s);        
        boolean flag = false;//flag to determine if valid string found at some level.
        while(!q.isEmpty()){
            String curr= q.poll();
            if(isValid(curr)){
                res.add(curr);
                flag= true;
            }
            if(!flag){//go to next level only if the valid string not found at higher level.
                for(int i=0; i<curr.length(); i++){
                    char c = curr.charAt(i);
                    if(Character.isLetter(c)) continue;
                    String str = curr.substring(0, i) + curr.substring(i+1);
                    if(!set.contains(str)){
                        q.add(str);
                        set.add(str);
                    }
                }
            }
        }
        return res;
    }	
	//Method to determine if given string has balanced parenthesis.
	private boolean isValid(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c == '(') count++;
            else if (c == ')') count--;
            if(count < 0) return false;
        }        
        return (count ==0);
    }   
    
	
	// Driver code to test above
	public static void main (String[] args) {	
		RemoveInvalidParentheses ob  = new RemoveInvalidParentheses();		
		String s= "()())()";
		System.out.println("Longest possible balanced substrings are : "+ob.removeInvalidParentheses(s));
	}
}
