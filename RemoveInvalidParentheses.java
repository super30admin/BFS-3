import java.util.*;
/*
TC: O(2^N * N); for every char we have two choices : choose or dont choose. and to check for validity we traverse the string of length N.
SC: O(2^N) recursion stack contains 2^N combinations of strings.

1. We do a level order traversal to get valid string with minimum removals. 
2. Keep a queue and a set to track already checked strings.
3. Keep removing one bracket at each index and verify validity. If not valid, put into queue. this will be considered 
in the next level.
4. After checking all strings by removing one character, if we have still not found a valid string, Go for second level.
5. A boolean flag is maintained to stop after finding a valid string.
6. isValid function checks for validity. As there is only one kind of bracket i.e., "()", we can keep a count instead of stack.
7. Add +1 for open bracket and -1 for closing bracket. if count goes to negative, or count != 0 at the end of string. It is not a valid string.

*/

public class RemoveInvalidParentheses {
    
    public List<String> removeInvalidParentheses(String s){
        List<String> output = new ArrayList<>();
        if(s == null) return output;

        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;

        q.add(s);
        set.add(s);

        while(!q.isEmpty()){
            String front = q.poll();

            if(isValid(front)){
                found = true;
                output.add(front);
            }

            if(!found){
                for(int x = 0; x < front.length(); x++){
                    if(front.charAt(x) != '(' && front.charAt(x) != ')') continue; 
                    String newStr = front.substring(0 , x) + front.substring(x + 1, front.length());
                    if(!set.contains(newStr)){
                        set.add(newStr);
                        q.add(newStr);
                    }
                }
            }
        }
        return output;
    }


    private boolean isValid(String str){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch == ')'){
                count -= 1;
                if(count < 0) return false;
            }else if(ch == '('){
                count += 1;
            }
        }
        return count == 0;
    }

    public static void main(String[] args){
        RemoveInvalidParentheses remP = new RemoveInvalidParentheses();
        System.out.println(remP.removeInvalidParentheses("())()"));
    }
}
