class Solution { //dfs
    List<String> res;
    HashSet<String> set;
    int max=0;
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<>();
        set = new HashSet<>();
        dfs(s);
        return res;
    }
    private void dfs(String s){
        //base
        if(s.length()<max) return;
        if(isValid(s)){
            if(s.length()>max){
                max=s.length();
                res = new ArrayList<>();  
            }
            res.add(s);
            return;
        }

        //logic
        int len=s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            String baby = s.substring(0,i)+s.substring(i+1,len);
            if(!set.contains(baby)){
                set.add(baby);
                dfs(baby);
            }
        }
    }
    private boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c=='('){
                count++;
            }
            else if(c==')'){
                count--;
                if(count<0) return false;
            }
        }
        return count==0;
    }
}
