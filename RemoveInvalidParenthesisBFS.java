// Time complexity: O(n^n) exponential
// Space complexity: O(n^n)

// Approach: BFS

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        // bfs
        Queue<String> queue = new LinkedList<>();
        // to check if the child has already been added to the queue so that we don't reprocess
        HashSet<String> set = new HashSet<>();
        // flag to check if any valid string was found for the given level in bfs, as we want to return only strings from that level in our final answer as they are the valid strings with minimum number of invalid parenthesis removed 
        boolean flag = false;
        
        queue.add(s);
        set.add(s);
        
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // at each level
                String curr = queue.poll();
                // check if current string is valid
                if (isValid(curr)) {
                    // add valid string of current level to the result
                    result.add(curr);
                    // make flag true. That means we have found the level with maximum valid string
                    flag = true;
                }
                // if the string is not valid, add all the children to the queue by removing one character at a time. To create children of the current string, we will just remove one character at a time from the string and add that substring to the queue and the set
                if (!flag) {
                    for (int j = 0; j < curr.length(); j++) {
                        Character c = s.charAt(j);
                        if (Character.isLetter(c)) continue;
                        String child = curr.substring(0, j) + curr.substring(j+1);
                        if (!set.contains(child)) {
                            queue.add(child);
                            set.add(child);
                        }
                    }
                }
            }
        }
        
        return result;
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