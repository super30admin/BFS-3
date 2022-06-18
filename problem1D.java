class Solution {
    List<String> result;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList();
        
        result = new ArrayList();
        set = new HashSet();
        dfs(s);
        
        return result;
    }
    
    private void dfs(String s){
        if(s.length() < max) return;
        
        if(isValid(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList();
                result.add(s);
            }
            else if(s.length() == max){
                result.add(s);
            }
        }
        else{
            for(int i = 0; i < s.length(); i++){
                        if(Character.isLetter(s.charAt(i))) continue;
                        String sub = s.substring(0, i) + s.substring(i + 1);
                        if(!set.contains(sub)){
                            set.add(sub);
                            dfs(sub);
                        }
                    }
        }
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}

//time complexity O(2^n) 
//space complexity O(2^n)