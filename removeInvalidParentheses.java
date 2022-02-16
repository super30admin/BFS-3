// Time Complexity :Exponential
// Space Complexity :O(n), where n is the length of string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// BFS Approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s== null || s.length() == 0) return result;

        boolean found = false;
        HashSet<String> set = new HashSet();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        set.add(s);

        while(!q.isEmpty()) {
            String curr = q.poll();
            if(isValid(curr)) {
                found = true;
                result.add(curr);
            }
            else if(found == false) {
                for (int i=0; i<curr.length(); i++) {
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String newStr = curr.substring(0, i) + curr.substring(i+1);
                    if (!set.contains(newStr)) {
                        set.add(newStr);
                        q.add(newStr);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count=0;

        for (char c: s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            else continue;

            if(count < 0) return false;
        }

        return count==0;
    }
}

// ------------------------------------------------------------------------------------------------------------------
// DFS Approach
class Solution {
    HashSet<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        if(s== null || s.length() == 0) return result;
        set = new HashSet();

        dfs(s);

        return result;
    }

    private void dfs(String s) {
        //base
        if(set.contains(s) || s.length() < max) return;

        //logic
        set.add(s);
        if(isValid(s)) {
            if (max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if(s.length() == max) {
                result.add(s);
            }
        }

        for (int i=0; i<s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) continue;
            String newStr = s.substring(0, i) + s.substring(i+1);
            dfs(newStr);
        }
    }

    private boolean isValid(String s) {
        int count=0;

        for (char c: s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            else continue;

            if(count < 0) return false;
        }

        return count==0;
    }
}