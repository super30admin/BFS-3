//Approach - 1: BSF, Set
//Time Complexity : Can you please explain, I have doubts about TC and Space
//Space Complexity : 

//Notes
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length()  == 0) return result;
        
        boolean flag = false;
        
        Queue<String> q = new LinkedList<>();
        q.add(s);
        
        HashSet<String>  set = new HashSet<>();
        set.add(s);
        
        while(!q.isEmpty()){
            
            //g=Going through all strings in that level 
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String curr = q.poll();
                
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                else{
                    if(!flag){
                        for(int j=0; j<curr.length(); j++){
                            //remove one brace and add it to set
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child)){
                                q.add(child);
                                set.add(child);
                            }
                        }
                    }
                }
                
            }
            
        }
        return result;
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}

//Approach - 2: DFS, Set, max
//Time Complexity : n^l ; length of string
//Space Complexity : 

//Notes
class Solution {
    List<String> result;
    Set<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        if(s == null || s.length()  == 0) return result;
        max = 0;
        
        dfs(s);
        return result;
    }
    
    private void dfs(String str){
        //base 
        if(str.length() < max) return;
        if(isValid(str)){
            if(str.length() > max){
                result = new ArrayList<>();
                max = str.length();
            }
            result.add(str);
            return;
        }
        //logic
        
        //add
        if(isValid(str)){
            result.add(str);
        }
        set.add(str);

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)) continue;
            String child = str.substring(0,i) + str.substring(i+1);
            if(!set.contains(child)){
                set.add(child);
                dfs(child);
            }
        }
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
