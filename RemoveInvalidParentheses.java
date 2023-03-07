class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.add(s);
        seen.add(s);
        while(!q.isEmpty() && !found) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    result.add(curr);
                    found = true;
                } else {
                    for(int i = 0; i < curr.length(); i++) {
                        if(curr.charAt(i) != '(' && curr.charAt(i) != ')') {
                            continue;
                        }
                        String newS = curr.substring(0, i) + curr.substring(i + 1);
                        if(!seen.contains(newS)) {
                            q.add(newS);
                            seen.add(newS);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}