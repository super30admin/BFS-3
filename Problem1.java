class Solution {
    //TC: O(n^2)
    //SC: O(n)
    HashSet<String> set;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
       this.set = new HashSet<>();
       this.result = new ArrayList<>();
        
    }

    private boolean isValid(String s){
        int count  = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == ')'){
                if(count  == 0) return false;
                count--;
            }else count++;
        }
        if(count != 0) return false;
        return true;
    }
}
