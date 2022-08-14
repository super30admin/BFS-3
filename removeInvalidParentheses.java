// Time Complexity : O(N*N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    Set<String> set;
    int max;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        //null
        if(s == null || s.length() == 0) return result;
        set = new HashSet<>();
        dfs(s);
        return result;
    }
    private void dfs(String s){
        //base
        if(set.contains(s)) return;
        if(s.length() < max) return;
        //logic
        if(isValid(s)){
            if(max < s.length()){
                result = new ArrayList<>();
            }
            max = s.length();
            set.add(s);
            result.add(s);
        } else{
            set.add(s);
            for(int i = 0; i < s.length(); i++){
                if(Character.isLetter(s.charAt(i))) continue;
                String curr = s.substring(0,i) + s.substring(i+1);
                
                dfs(curr);
            }
        }
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c))continue;
            else if(c == '('){
                count++;
            } else if(c == ')'){
                if(count == 0)return false;
                else count--;
            }
        }
        return count == 0;
    }
}


/*
//bfs
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //null
        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s); set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                } else{
                    if(!flag){
                        for(int j = 0; j < curr.length(); j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j) + curr.substring(j+1);
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
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c))continue;
            else if(c == '('){
                count++;
            } else if(c == ')'){
                if(count == 0)return false;
                else count--;
            }
        }
        return count == 0;
    }
}
*/