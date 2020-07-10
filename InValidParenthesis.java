// Time Complexity : O(2^n) where n is the number of combinations of brackets
// Space Complexity : O(n) where n is the number of combinations of brackets we have seen in the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Difficult problem to code intuitively
/* Your code here along with comments explaining your approach: Put the string s in the queue. Maintain a set that keeps a track of combinations
of brackets we have seen till now. for each of the strings, explore further by removing the bracket one by one and check each of them as valid or invalid
string. Maintain a count to check the number of brackets if the count < 0 or not 0 at the end, it means that it is invalid. If it is a valid string
make the flag as true means we wont go to the next level since we need this in minimum number of steps. But we would explore all the remaining
strings in the queue so that we do not miss out on other valid strings if we have.
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
         if(s == null || s.length() == 0) {
             result.add("");                                                        // Edge case
             return result;
         }
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();;
        q.add(s);
        boolean flag = false;                                                               // Flag to detect valid string
        while(!q.isEmpty() && !flag){
        int size = q.size();
        for(int j = 0; j < size; j++)
        {
            String curr = q.poll();                                                             // Get the latest string in the queue
            if(isValid(curr)){
                flag = true;                                                                // Valid string found
                result.add(curr);                                                           // Add it to the result
            }else{
                for(int k = 0; k < curr.length(); k++){
                   if(Character.isLetter(curr.charAt(k))) continue;                                                 // If it is a letter skip
                   String temp = curr.substring(0, k) + curr.substring(k+1);            // Generate all possible bracket combinations
                    if(!set.contains(temp)) {
                    q.add(temp);                                                                // Add string to the queue to be checked next
                    set.add(temp);                                                      // Add it to the seen 
                    }
                }
                }
            }
        }
        return result;
    }
    private boolean isValid(String str){
        if(str == null) return true;
        int count  = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                count++;                                                                            // Increase the count
            } else 
            if(str.charAt(i) == ')'){
                count--;                                                                                    // Decrease the count
                if(count < 0) return false;                                                     // Count becomes negative implies non balanced
            }
        }
        return count == 0;                                                                          // Check if balanced or not
        }
}