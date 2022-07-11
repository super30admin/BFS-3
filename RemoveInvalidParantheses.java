// Time Complexity : O(N^N)
// Space Complexity : O(N^N - not exactly it will have all unique combinations)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//dfs
class Solution {
    List<String> res;
    Set<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<>();
        // maintain set to not explore repeats
        set = new HashSet<>();
        dfs(s);
        return res;
    }
    private void dfs(String s) {
        // when we look at repeat we don't explore it further
        if(set.contains(s)) return;
        // if string is valid
        if(isValid(s)) {
            // we explore the deepest first,
            // so there's a possibility we might find the smallest substring possible serving the purpose
            // when we explore the next highest, we should abandon previous results and start a fresh list with max length
            if(s.length() > max){
                res = new ArrayList<>();
                max = s.length();}
            if(s.length() == max) {
                res.add(s);
                set.add(s);
            }
            return;
        }
        set.add(s);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            // if an alphabet comes, we should not do anything
            if(Character.isLetter(c)) continue;
            // else create all possible combinations excluding one character at every level
            String child = s.substring(0, i)+s.substring(i+1);
            dfs(child);
        }
    }
    // we are using counter to verify if it is a valid string
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            else if(c == '(') count++;
            else count --;
            // when there's a negative count, meaning we have a closing bracket now, but we don't have any opening bracket to close it
            if(count < 0) return false;
        }
        return count == 0;
    }
}


//Time: O(N^N) - N-1 every level at children | space: O(N^N)
//bfs

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        boolean isLevelFound = false;
        while(!q.isEmpty() && !isLevelFound) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    // the first level which has valid parantheses in a string,
                    // we don't explore any of its children
                    // we only will explore that level
                    isLevelFound = true;
                    res.add(curr);
                }
                if(!isLevelFound) {
                    for(int j=0;j<curr.length();j++) {
                        char c = s.charAt(j);
                        if(Character.isLetter(c)) continue;
                        String child = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(child)) {
                            q.add(child);
                            set.add(child);
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            else if(c == '(') count++;
            else count --;

            if(count < 0) return false;
        }
        return count == 0;
    }
}