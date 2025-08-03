// Time Complexity :O(2^L*L)
// Space Complexity : O(2^L+L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Exxhaustively remove each brach and check if resultant parenthesis is valid or not. Add all valid parenthesis to list
/// to keep track and prevent repeated sub problems
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        helper(s, 0, "", 0, set);
        List<String> res = new ArrayList<>(set);
        int maxLength = 0;
        for(int i=0;i<res.size();i++){
            maxLength = Math.max(maxLength, res.get(i).length());
        }
        List<String> res2=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            if(res.get(i).length()==maxLength){
                res2.add(res.get(i));
            }
        }
        return res2;
    }
    public void helper(String s, int i, String path, int cnt, HashSet<String> set){
        //base
        if(i==s.length()){
            if(cnt==0){
                set.add(path);
            }
            return;
        }
        if(cnt<0){
            return;
        }
        //logic
        char ch = s.charAt(i);
        if(ch=='(' || ch==')'){
            //case 1: add current bracket to path
            if(ch=='(')
                helper(s, i+1, path+ch, cnt+1, set);
            else
                helper(s, i+1, path+ch, cnt-1, set);
            //case 2: don't add
            helper(s, i+1, path, cnt, set);
        }
        else{
            helper(s, i+1, path+ch, cnt, set);
        }
    }
}