/*
Time: O(2^n)
Space: O(n)
*/
class Solution {
    private Set<String> valid = new HashSet<>();
    private int min = Integer.MAX_VALUE;
    
    public List<String> removeInvalidParentheses(String s) {
        bt(s, 0, 0, 0, 0, new StringBuilder());
        return valid.stream().collect(Collectors.toList()); // convert out set to a list
    }
    
    private void bt(String s, int l, int r, int i, int removed, StringBuilder sb) {
        if (removed > min) // no point in exploring a sub-optimal solution
            return;
        
        if (i == s.length()) { // traversed the entire string
            if (l == r) { // is valid
                if (min > removed) // we found a smaller solution, so reset
                    valid.clear();
                min = removed;
                valid.add(sb.toString());
            }
            return;
        }
        
        int len = sb.length();
        char c = s.charAt(i);
        if (c != '(' && c != ')') { // always keep non-parens char
            sb.append(c);
            bt(s, l, r, i+1, removed, sb);
        } else {
            bt(s, l, r, i+1, removed+1, sb); // consider sequence without current char
            sb.append(c); // now consider WITH the current char
            if (c == '(') {
                bt(s, l+1, r, i+1, removed, sb);
            } else if (r < l) { // ensures adding ")" to current SB remains valid
                bt(s, l, r+1, i+1, removed, sb);
            }
        }
        sb.deleteCharAt(len); // backtrack
    }
}