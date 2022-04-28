import java.util.*;
/*
Time Complexity: O(n!), where n is the length of the given string
Space Complexity: O(N) amortized, as we are using HashSet, Queue
Run on leetcode: yes
Any difficulties: no

Approach: The problem has three parts
1. Processing given string
2. Removing characters in order to make it valid
3. Checking if the string is validParenthese or not

I am using BFS to get all the combinations one can make after removal of certain open or close parentheses
 */
public class RemoveInvalidParenthese {
    public static List<String> removeInvalidParenthese(String s){
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        set.add(s);

        while(!queue.isEmpty() && result.size() == 0){
            // The nextQueue is required to process every level
            Queue<String> nextQueue = new LinkedList<>();

            while(!queue.isEmpty()){

                String currString = queue.remove();

                if(isValidParenthese(currString)){
                    result.add(currString);
                }else{
                    for(int i = 0; i<currString.length(); i++){
                        String nextVariation =
                                currString.substring(0,i)
                                + (i+1 == currString.length() ? "" : currString.substring(i+1));
                        if(!set.contains(nextVariation)){
                            set.add(nextVariation);
                            nextQueue.add(nextVariation);
                        }
                    }
                }
            }
            queue = nextQueue;
        }
        return result;
    }
    public static boolean isValidParenthese(String s){
        int count = 0;

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if(count<0){
                return false;
            }
        }
        return count == 0;
    }
    public static void main(String[] args){
        System.out.println("Remove Invalid Parenthese: "+ removeInvalidParenthese("()())()"));
    }
}
