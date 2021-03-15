import java.util.ArrayList;
import java.util.List;
// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class RemoveInvalidParentheses {

    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            helper(s, 0, 0, res, new char[]{'(', ')'});
            return res;
        }

        //helper method to remove invalid parenthesis
        private void helper(String s, int left, int right, List<String> res, char[] parenthesis){
            int stack=0;
            int n = s.length();
            for(;right<n; right++){
                char c = s.charAt(right);
                if(c==parenthesis[0]){
                    stack++;
                }else if(c==parenthesis[1]){
                    stack--;
                }
                if(stack<0) break;
            }

            if(stack < 0){
                for(;left<=right; left++){
                    char c = s.charAt(left);
                    if(c!=parenthesis[1]) continue;
                    if(left > 1 && s.charAt(left) == s.charAt(left-1)) continue;
                    helper(s.substring(0, left) + s.substring(left+1), left, right, res, parenthesis);
                }
            }else if(stack > 0){
                helper(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[]{')', '('});
            }else{
                res.add(parenthesis[0]== '(' ? s: new StringBuilder(s).reverse().toString() );
            }
        }
    }

}
