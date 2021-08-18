class Solution {
        public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        
        List<String> validStrInCurLevel = new ArrayList<>(); // Indicate whether a valid node has been met as well
        
        // Level-BFS
        while(!q.isEmpty()) {
            int sz = q.size();
            for (int j = 0; j < sz; j++) {
                String cur = q.poll();
                
                if (valid(cur)) {
                    validStrInCurLevel.add(cur);
                }
                
                if (validStrInCurLevel.isEmpty()) { // If no valid node has been met
                    // Add adjacent nodes to queue
                    for (int i = 0; i < cur.length(); i++) {
                        if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                            String adj = cur.substring(0, i) + cur.substring(i + 1);
                            if (!visited.contains(adj)) {
                                visited.add(adj);
                                q.offer(adj);
                            }
                        }
                    }
                }
            }
            if (!validStrInCurLevel.isEmpty()) { // If a valid node has been met, return valid nodes in the same level
                return validStrInCurLevel;
            }
        }
        throw null;
    }
    
    private boolean valid(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' )
                score++;
            else if (s.charAt(i) == ')')
                score--;
            if (score < 0)
                return false;
        }
        return score == 0;
    }
}
