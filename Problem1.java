// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int max;
    HashSet<String> set;
    List<String> ans;
    public List<String> removeInvalidParentheses(String s) {
        this.set = new HashSet<>();
        this.ans = new ArrayList<>();
        
        dfs(s);
        return ans;
    }
    private void dfs(String s){
        if(s.length() < max)
            return;
        if(isValid(s)){
                if(s.length() > max){
                ans = new ArrayList<>();
                max = s.length();
                ans.add(s);}
                else if(s.length() == max)
                ans.add(s);
            }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            String child = s.substring(0,i) + s.substring(i+1);
            if(!set.contains(child)){
                
                set.add(child);
                dfs(child);
            }
        }
    }
    private boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(cnt == 0)
                    return false;
                cnt--;
            }
            else if(ch == '(')
                cnt++;
        }
        return cnt==0;
    }
}