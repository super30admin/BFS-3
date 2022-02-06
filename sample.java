import java.util.*;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample {
    //o(n^2) time and o(n) space
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        set.add(s);
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int j = 0; j < size; j++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                else if(!flag){
                    for(int i = 0; i < curr.length(); i++){
                        if(Character.isLetter(curr.charAt(i))) continue;
                        String child = curr.substring(0, i) + curr.substring(i+1);
                        if(!set.contains(child)){
                            set.add(child);
                            q.add(child);
                        }
                    }    
                }
            }
            
        }
        return result;
    }
    private boolean isValid(String curr){
        int count = 0;
        for(int i = 0; i < curr.length(); i++){
            char c = curr.charAt(i);
            if(c == '('){
                count++;
            } else if(c ==')'){
                count--;
            } if (count < 0) return false;
        }
        return count==0;
    }

        HashSet<String> set;
         List<String> result;
        int max;
        public List<String> removeInvalidParentheses2(String s) {
            set = new HashSet<>();
           result = new ArrayList<>();
            
            helper(s);
            
            return result;
        }
        private void helper(String s){
            //base
            if(set.contains(s) || s.length() < max) return;
            //logic
            set.add(s);
            if(isValid(s)){
                if(s.length() > max){
                    max = s.length();
                    result = new ArrayList<>();
                    result.add(s);
                } else if(s.length() == max){
                    result.add(s);
                }
                
                
            } else {
                //dfs on baby
                for(int i = 0; i < s.length(); i++){
                    String curr = s.substring(0, i) + s.substring(i+1);
                    helper(curr);
                }
            }
            
            
        }
        
}