//TC - O(n^n)
//SC - O(n) size of stack
//Did this code run on leetcode? Yes

class Solution {
    
    List<String> result;
    HashSet<String> set;
    int max;
    
    public List<String> removeInvalidParentheses(String s) {
        
        result = new ArrayList<>();
        set = new HashSet<>();
        
        dfs(s);
        
        return result;
        
    }
    
    private void dfs(String s){
        //base
        if(s.length() < max || set.contains(s)) return;
        
        if(isValid(s)){
            if(s.length()>max){
            max = s.length();
            result = new ArrayList<>();
            result.add(s);
            }else if(s.length()==max){
            result.add(s); 
            }
        set.add(s);
        }
        
        //logic
        
        set.add(s);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            String child = s.substring(0,i) + s.substring(i+1);
            //set.add(child);
            dfs(child);
        }
    }
    
    private boolean isValid(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='(') count++;
            if(c==')') count--;
            if(count<0) return false;
        }
        return count==0;
    }
}