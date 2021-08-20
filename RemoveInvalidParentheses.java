// Time Complexity : O(2 ^ n)
// Space Complexity : O(n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0;i < size; i++){
                String cur = q.poll();
                if(isValid(cur)){
                    flag = true;
                    res.add(cur);
                    continue;
                }
                for(int j = 0; j < cur.length(); j++){
                    char c = cur.charAt(j);
                    if(Character.isLetter(c))
                        continue;
                    String newStr = cur.substring(0, j) + cur.substring(j + 1);
                    if(!set.contains(newStr)){
                        q.add(newStr);
                        set.add(newStr);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(count == 0)
                    return false;
                count--;
            }
            else if(c == '(')
                count++;
        }
        return count == 0;
    }
}