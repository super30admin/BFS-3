// S30 Big N Problem #142 {Hard}
// 301. Remove Invalid Parentheses

// Time Complexity :O(2^n) where n is the length of main string
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// Level by level check
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if(s==null) return result;
        
        Queue<String> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        boolean flag=false;
        q.add(s);
        set.add(s);
        
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){
                flag=true;
                result.add(curr);
            }
            if(!flag){
                for(int i=0; i<curr.length();i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String temp=curr.substring(0,i)+curr.substring(i+1);
                    
                    if(!set.contains(temp)){
                        set.add(temp);
                        q.add(temp);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
            }
            else if(c==')'){
                if(count==0) return false;
                count--;
            }
        }
        return count==0;
    }   
}