// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// BFS- add s to the Queue, and hashset, then remove each and add it to the queue and hasset, take care of letter in the string, also, when found the valid string then set the flag to true, so that we will not explore the other options.
// Your code here along with comments explaining your approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        hs.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    res.add(curr);
                    flag = true;
                }else{
                    if(!flag){
                        for(int j = 0; j < curr.length(); j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String newS = curr.substring(0, j)
                                + curr.substring(j+1,curr.length());
                            if(!hs.contains(newS)){
                                hs.add(newS);
                                q.add(newS);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                cnt++;
            }else if(ch == ')'){
                cnt--;
                if(cnt < 0) return false;
            }
        }
        return cnt == 0;
    }
}
