import java.util.*;

public class RemoveInvalidParentheses {
     //Try with all options(Valid ones) by removing the character one by one.
    
    //TC: O(N^2)
    //SC: O(N^2)
    public List<String> removeInvalidParentheses(String s) {
        //BFS
        List<String> result = new ArrayList();
        if(s == null || s.length() == 0) return result;
        
        Queue<String> queue = new LinkedList();
        HashSet<String> visited = new HashSet();
        queue.add(s);     
        visited.add(s);
        boolean flag = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0;j<size;j++) {
                String current = queue.poll();
                if(isValid(current)) {
                    result.add(current);
                    flag = true;
                    break;
                }
                if(!flag) {
                    for(int i=0;i<current.length();i++) { 
                        if(Character.isLetter(current.charAt(i))) continue;
                        String newString = new StringBuilder(current).deleteCharAt(i).toString();
                        if(!visited.contains(newString)) { 
                            visited.add(newString);
                            queue.add(newString); 
                        }
                        }
                    }
                }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char currentChar = s.charAt(i);
            switch(currentChar) {
                    case '(':{
                       count++; 
                        break;
                    }
                    case ')': {
                        if(count == 0) return false;
                        count-- ;
                        break;
                    }
            }
        }
        return count == 0;
    }
    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        List<String> result = removeInvalidParentheses.removeInvalidParentheses("()())()");
        System.out.println("The result: "+ result);

    }
}
