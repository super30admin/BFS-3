//Time -O(n^n)
//Space - O(n)
class Solution {
    List<String> result;
    HashSet<String> set;
    int max =0;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        dfs(s);
        return result;
    
    }
    
    private void dfs(String s){
        
        if(s.length() < max || set.contains(s) ){
            return;
        }
        if(isValid(s)){
            System.out.println("Valid");
            if(s.length() > max){
                result = new ArrayList<>();
                result.add(s);
                max = s.length();
            }else if(s.length() == max){
                result.add(s);
            }
            set.add(s);
        }
        
        
        //logic
        set.add(s);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            String substr = s.substring(0,i)+ s.substring(i+1);
            dfs(substr);
        }
    }
    private boolean isValid(String s){
        System.out.println(s);
        int count =0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else if(Character.isLetter(c)){
                continue;
               
            }else{
                count--;
            }
            if(count<0) return false;
        }
       
        return count==0;
    }
}