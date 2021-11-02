// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else {
                    if(!flag) {
                        for(int i = 0; i < curr.length(); i++) {
                            // what if the ith index is a letter
                            if(Character.isLetter(curr.charAt(i))) continue;
                            String child = curr.substring(0, i) + curr.substring(i + 1);
                            if(!set.contains(child)) {
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                count++;
            else if(c == ')') {
                count--;
                if(count < 0)
                    return false;
            }
        }
        return count == 0;
    }
    
}