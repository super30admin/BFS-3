// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        HashSet<String> set = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag=true;
                }else{
                    if(!flag){
                        for(int k=0;k<curr.length();k++){
                            char c = curr.charAt(k);
                            if(Character.isAlphabetic(c))
                                continue;
                            String child = curr.substring(0,k)+curr.substring(k+1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }

                }
            }
            if(flag){
                break;
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                continue;
            }
            if(c == '('){
                cnt++;
            }
            else if(c==')'){
                if(cnt==0)
                    return false;
                cnt--;

            }
        }
        return cnt==0;
    }
}