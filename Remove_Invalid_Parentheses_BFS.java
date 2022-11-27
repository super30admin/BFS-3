// TC : O(exponential)
// SC : O(n)
// Method - BFS

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        int n = s.length();
        
        Queue<String> q = new LinkedList<>();
        
        q.add(s);
        boolean found = false;
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            if(isValid(curr)) {
                result.add(curr);
                set.add(curr);
                found = true;
            }
            else if(found == false) {
                for(int i = 0; i < curr.length(); i++) {
                    if(curr.charAt(i) >= 'a' && curr.charAt(i) <= 'z') continue;
                    String b = curr.substring(0, i) + curr.substring(i + 1);
                    if(!set.contains(b)) {
                        q.add(b);
                        set.add(b);
                    }
                }
            }
        }
        return result;
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
