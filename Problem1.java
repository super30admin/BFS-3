// Time Complexity : O(n*n!)
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//301. Remove Invalid Parentheses
//https://leetcode.com/problems/remove-invalid-parentheses/

class Solution {
    // BFS
    // time: O(n*n!)
    // space: O(n!)
    public List<String> removeInvalidParentheses(String s) {

        // Queue
        // Set

        // Put string in the queue
        // If valid, add to result and flag = true (flag set to true so that we don't
        // add babies to the queue)
        // If not valid, add its babies to queue and flag remains false
        boolean flag = false;

        Queue<String> q = new LinkedList<>();

        HashSet<String> set = new HashSet<>();

        List<String> result = new ArrayList<>();

        set.add(s);
        q.add(s);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                if (isValid(q.peek())) {

                    flag = true;
                    result.add(q.peek());

                } else {

                    if (!flag) {

                        // add babies to the queue
                        for (int j = 0; j < q.peek().length(); j++) {

                            if (Character.isLetter(q.peek().charAt(j)))
                                continue;
                            String child = q.peek().substring(0, j) + q.peek().substring(j + 1);

                            if (!set.contains(child)) {
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
                q.poll();
            }
        }

        return result;

    }

    // separate fn to check if it is valid or not using counters
    private boolean isValid(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch))
                continue;

            if (ch == ')')
                count--;
            else if (ch == '(')
                count++;

            if (count <= -1)
                return false;

        }

        if (count == 0)
            return true;
        else
            return false;

    }

}

/*
class Solution {
    // DFS, recursion
    // time:
    // space:

    int max;
    List<String> result;
    HashSet<String> set;

    public List<String> removeInvalidParentheses(String s) {

        max = 0;

        result = new ArrayList<>();
        set = new HashSet<>();

        dfs(s);

        return result;
    }

    private void dfs(String s) {
        // base
        if (s.length() < max)
            return;
        if (isValid(s)) {

            if (s.length() > max) {
                result = new ArrayList<>();
            }
            max = s.length();
            result.add(s);
        }

        // logic
        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetter(s.charAt(i)))
                continue;

            String child = s.substring(0, i) + s.substring(i + 1);

            if (!set.contains(child)) {
                set.add(child);
                dfs(child);
            }
        }
    }

    private boolean isValid(String s){
        
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch)) continue;
            
            if(ch == ')') count--;
            else if(ch == '(') count++;
            
            if(count <= -1) return false;
            
        }
        
        if(count == 0) return true;
        else return false;
        
    }

}*/