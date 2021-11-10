class Solution {
    Set<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        helper(s);
        return result;
    }
    
    private void helper(String s) {
        if(set.contains(s) || s.length()<max) return;
        set.add(s);
        if(isValid(s)) {
            if(s.length() > max) {
                result = new ArrayList<>();
                result.add(s);
                max = s.length();
            } else if(s.length()==max) {
                result.add(s);
            }
        } else {
            for(int i = 0; i< s.length(); i++) {
                String curr = s.substring(0, i) + s.substring(i+1);
                helper(curr);
            }
        }
    }
    
    private boolean isValid(String curr) {
        int count = 0;
        for(int i = 0; i< curr.length(); i++) {
            if(curr.charAt(i)=='(') count++;
            else if(curr.charAt(i)==')'){
                count--;
                if(count<0) return false;
            }
        }
        return count==0;
    }
}