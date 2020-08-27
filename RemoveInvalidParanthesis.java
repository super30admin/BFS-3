//time:(n^2)(2^n)
//space:n
//leetcode:Yes


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null)return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);    
            }
            if(!flag){
                for(int i = 0; i < curr.length(); i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String child = curr.substring(0,i) + curr.substring(i+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
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
            if(c == '('){
                count++;
            }else if(c == ')'){
                if(count == 0)return false;
                count--;
            }
        }
        return count == 0;
    }
}