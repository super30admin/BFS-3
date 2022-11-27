// TC : O(exponential)
// SC : O(n)
// Method - DFS

class Solution {
    List<String> result;
    HashSet<String> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        
        dfs(s);
        
        return result;
    }
    
    private void dfs(String s) {
        
        if(set.contains(s) || s.length() < max) return;
        
        if(isValid(s)) {
            if(s.length() > max) {
                result = new ArrayList<>();
                max = Math.max(max, s.length());
            }
            result.add(s);
            set.add(s);
            return;
        }
        
        set.add(s);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') continue;
            String b = s.substring(0, i) + s.substring(i + 1);
            dfs(b);
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            if(s.charAt(i) == ')') {
                count--;
                if(count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
