// Time Complexity : O(2^n)
// Space Complexity : O(2^n * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We do a BFS traversal by removing one parantheses at a time and check if the formed strings are valid and
subsequently add their babies to the queue if not visited. We dont do level by level as for sure the valid
result at one level cannot produce valid results at next level. A valid scenario will always have even occurence
and next level contains odd count of characters.
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visitedSet = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.add(s);
        visitedSet.add(s);
        boolean flag = false;

        while(!q.isEmpty()) {
            String curr = q.poll();
            if(isValid(curr)) {
                result.add(curr);
                flag = true;
            }
            else {
                if(!flag) {
                    for(int k = 0 ; k < curr.length() ; k++) {
                        if(Character.isAlphabetic(curr.charAt(k)))
                            continue;
                        String subStr = curr.substring(0, k) + curr.substring(k + 1);
                        if(!visitedSet.contains(subStr)) {
                            visitedSet.add(subStr);
                            q.add(subStr);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String str) {
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            if(Character.isAlphabetic(str.charAt(i)))
                continue;
            if(str.charAt(i) == '(')
                count++;
            else if(str.charAt(i) == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}