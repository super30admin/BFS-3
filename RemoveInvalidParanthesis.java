// Time Complexity : O(n!) (number of unique strings formed)
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Exhaustively find all the possible strings by choosing and not choosing the ith index
// In BFS when iterating a level, if a result is found, do not explore further as deeper levels means more removals and smaller length
// In DFS we use max length found to not process strings with smaller length

class Solution {

    List<String> result = new ArrayList();
    int max;
    HashSet<String> set = new HashSet();

    public List<String> removeInvalidParenthesesDFS(String s) {
        if (s.length() < max)
            return result;

        if (isBalanced(s)) {
            if (s.length() > max) {
                max = s.length();
                result = new ArrayList();
            }
            result.add(s);
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)))
                continue;
            String child = s.substring(0, i) + s.substring(i + 1);
            if (!set.contains(child)) {
                set.add(child);
                removeInvalidParenthesesDFS(child);
            }
        }

        return result;
    }

    public List<String> removeInvalidParenthesesBFS(String s) {
        Queue<String> q = new LinkedList();
        HashSet<String> set = new HashSet();
        List<String> result = new ArrayList();
        q.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String pop = q.poll();
                if (isBalanced(pop)) {
                    result.add(pop);
                    flag = true;
                }
                for (int i = 0; i < pop.length(); i++) {
                    if (Character.isAlphabetic(pop.charAt(i)))
                        continue;
                    String child = pop.substring(0, i) + pop.substring(i + 1);
                    if (!set.contains(child) && !flag) {
                        q.add(child);
                        set.add(child);
                    }
                }
            }
        }

        return result;
    }

    private boolean isBalanced(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c))
                continue;
            if (c == '(')
                cnt++;
            else
                cnt--;
            if (cnt < 0)
                return false;
        }
        return cnt == 0;
    }
}