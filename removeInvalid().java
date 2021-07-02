// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c= s.charAt(i);
            if(c == '(') count ++;
            if(c == ')') count --;
            if(count < 0) return false;
        }
        return count == 0;
    }
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        boolean found = false;
        set.add(s);
        q.add(s);
        while(!q.isEmpty() && !found){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    found = true;
                }
                else{
                    for(int j = 0 ; j < curr.length() ; j++){
                        if(Character.isLetter(curr.charAt(j))) continue;
                        String baby = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(baby)){
                            q.add(baby);
                            set.add(baby);
                        }
                    }
                }                
            }
            

        }
        return result;
    }
}
