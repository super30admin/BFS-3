//https://leetcode.com/problems/remove-invalid-parentheses
//TC: 2^n
//SC: o(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null)
            return result;
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(!isValid(curr)){
                    for(int j=0;j<curr.length();j++){
                        if(curr.charAt(j)!='(' && curr.charAt(j)!=')') continue;
                        String child = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(child)){
                            set.add(child);
                            if(!isValid(child)){
                                q.add(child);
                            }else{
                                result.add(child);
                                flag = true;
                            }
                        }
                    }
                }else{
                    result.add(curr);
                    flag = true;
                }
            }
        }
        //if(result.isEmpty()) result.add("");
        return result;
    }
    private boolean isValid(String s){
        int count=0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else if(s.charAt(i)==')'){
                count--;
            }
            if(count<0) return false;
        }
        return count==0;
    }
}
