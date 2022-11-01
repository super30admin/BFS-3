// Time complexity: O(n^n) exponential
// Space complexity: O(n^n)

// Approach: DFS

class Solution {
    List<String> result;
    HashSet<String> set;
    int max; // max variable to store the maximum length of valid string found. Whenever the max gets updated, we have to create a new array list so that we remove all smaller valid strings from the result
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        if (s == null || s.length() == 0) return result;
        // dfs
        dfs(s);
        return result;
    }
    
    private void dfs(String s) {
        // base
        if (s.length() < max) return; // if the string is smaller than max, we don't need to continue the dfs
        if (isValid(s)) { // if string is valid
            if (s.length() > max) { // if string length is greater than max, make max the string length and clear out the string
                max = s.length();
                result = new ArrayList<>();
                result.add(s);  
            }
            else if (s.length() == max) { // if the string is valid and the length is equal to that max, add it to the result
                result.add(s);
            }
        }
        
        // logic
        set.add(s);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isLetter(c)) continue;
            String child = s.substring(0,i) + s.substring(i+1);
            if (!set.contains(child)) {
                dfs(child);
            }
        }
    }
    
    private boolean isValid(String s) {
        // check if string has valid parenthesis
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}