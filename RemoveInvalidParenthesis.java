//Time Complexity O(N^N)
//Space Complexity O(N)
//Leetcode tested

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        int mr = getMin(s);
        HashSet<String> res = new HashSet<>();
        solution(s,mr,res);
        return new ArrayList<>(res);
    }
    public static int getMin(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    stack.push(ch);
                }else if (stack.peek() == ')'){
                    stack.push(ch);
                }else if (stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
    public void solution(String s,int mra, HashSet<String> set){
        if(mra == 0){
            int mrNow = getMin(s);
            if(mrNow == 0){
                if(!set.contains(s))
                    set.add(s);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            solution(left+right,mra-1,set);
        }
    }
}
