// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    
    Set<String> visited;
    List<String> result;
    
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        Queue<String> q = new LinkedList<>();
        visited = new HashSet<>();
        result = new ArrayList<>();
        
        q.add(s);
        visited.add(s);
        boolean found = false;
        
        while(!q.isEmpty()) {
            String current = q.poll();
            
            if(isValid(current) && !found) {
                result.add(current);
                found = true;
            } else {
                if(found == false) {
                    for(int i = 0; i < current.length(); i++) {
                        if(Character.isLetter(current.charAt(i))) continue;
                    String substring = current.substring(0, i) + current.substring(i + 1);
                    
                    if(!visited.contains(substring)) {
                        visited.add(substring);
                        q.add(substring);
                    }
                }                   
                }
                
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                count--;
                if(count < 0 ) return false;

            }
        }
        
        return count == 0;
    }
}