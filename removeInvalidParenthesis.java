/**
TC: O(2^N) N: length of String s.
SC: O(N) N: size of the recursive stack.
Approach: Implement recursion with Backtracking.Keep track of openBrackets & closing brackets.
 */

class Solution {
    Set<String> set = new HashSet<>();
    int tot_removed = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        backtrack(0,s, 0, 0, new StringBuilder(), 0);
        return new ArrayList<>(set);
    }


    private void backtrack(int idx, String s, int leftCount, int rightCount, StringBuilder curr, int removed){
        if(idx == s.length()){
            if(leftCount == rightCount){
                if(tot_removed > removed){
                    tot_removed = removed;
                    set.clear();
                }
                set.add(new String(curr.toString()));
            }

            return;
        }

        if(removed > tot_removed) return;

        if(leftCount < rightCount)
            return;

        char ch = s.charAt(idx);
        
        if(s.charAt(idx) != '(' && s.charAt(idx) != ')'){
            curr.append(ch);
            backtrack(idx+1, s, leftCount, rightCount, curr, removed);
            curr.deleteCharAt(curr.length()-1);

        }else{
            if(ch == '('){
                backtrack(idx+1, s, leftCount, rightCount, curr, removed+1);
                curr.append(ch);
                backtrack(idx+1, s , leftCount+1, rightCount, curr, removed);
                curr.deleteCharAt(curr.length()-1);
            }else{
                backtrack(idx+1, s, leftCount, rightCount, curr, removed+1);
                curr.append(ch);
                backtrack(idx+1, s , leftCount, rightCount+1, curr, removed);
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}