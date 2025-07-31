// TC: O(2^n)
// SC: O(2^n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> bfs = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        bfs.add(s);
        visited.add(s);

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                String curr = bfs.poll();

                if(isValid(curr)){
                    result.add(curr);
                }

                if (result.size() > 0){
                    continue;
                }

                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < curr.length(); j++) {
                    char deleted = sb.charAt(j);
                    if (deleted == ')' || deleted == '(') {
                        sb.deleteCharAt(j);
                        if (!visited.contains(sb.toString())) {
                            bfs.add(sb.toString());
                            visited.add(sb.toString());
                        }
                        sb.insert(j, deleted);
                    }

                }

            }
        }
        return result;
    }

    // TC: O(n)
    // SC: O(n)
    private boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == ')') {
                if (st.isEmpty() || st.peek() != ch) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();

    }
}