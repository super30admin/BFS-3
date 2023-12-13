// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RemoveInvalidParantheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            if(s == null || s.length() == 0)
                return new ArrayList<>();

            List<String> result = new ArrayList<>();
            Set<String> set = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.add(s);
            set.add(s);

            boolean found = false;
            while(!q.isEmpty() && !found){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    String curr = q.poll();
                    if(isValid(curr)){
                        found = true;
                        result.add(curr);
                    }
                    else{
                        if(!found){
                            for(int  j = 0; j < curr.length(); j++){
                                char c = curr.charAt(j);
                                if(Character.isAlphabetic(c))
                                    continue;
                                String child = curr.substring(0, j) + curr.substring(j+1);
                                if(!set.contains(child)){
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

        private boolean isValid(String str){
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '(')
                    count++;
                else if(c == ')'){
                    if(count == 0)
                        return false;
                    count--;
                }
            }
            return count == 0;
        }
    }
}
