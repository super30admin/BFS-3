// Time Complexity : O(n!)
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : some small problems

import java.util.*;

class InvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0) return result;

        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        q.add(s);
        set.add(s);
        boolean flag = false;

        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(!isValid(curr)){
                    if(!flag){
                        //check for alphabets
                        for(int j=0;j<curr.length();j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            else{
                                String child = curr.substring(0,j)+curr.substring(j+1,curr.length());
                                if(!set.contains(child)){
                                    q.add(child);
                                    set.add(child);
                                }
                            }
                        }
                    }
                }
                else{
                    flag = true;
                    result.add(curr);
                }
            }
        }

        return result;

    }

    private boolean isValid(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='(') count++;
            else{
                count--;
            }

            if(count<0) return false;
        }

        return count==0;
    }

    public static void main(String [] args){
        InvalidParentheses ip = new InvalidParentheses();
        System.out.println(ip.removeInvalidParentheses("()())()"));
    }
}

