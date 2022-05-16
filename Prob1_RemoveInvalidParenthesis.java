//TC : O(N^N) -- For n letters --> n-1 -> n-2 -> n-3 like this for worst case
//SC : O(N) -- For using set

//DFS Solution
class Solution {
    List<String> result;
    int max;
    HashSet<String> set;
    
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>() ;
        if(s == null || s.length() == 0)    return result;
        
        set = new HashSet<>();
        dfs(s);
        return result;
    }
    public void dfs(String s){
        //Base cases
        if(s.length() < max || set.contains(s) ) return;
        if(isValidString(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }else if(s.length() == max){
                result.add(s);
            }
        }
        set.add(s);
        
        //Main Logic
        for(int i = 0; i< s.length(); i++){
            if(Character.isLetter(s.charAt(i)) )  continue;
            String curr = s.substring(0, i) + s.substring(i+1);
            dfs(curr);
        }
        
    }
    
    
    public boolean isValidString(String s){
        int count = 0;
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch))  continue;
            if(ch == '(')   count++;
            else if(ch == ')') count--;
            
            
            if(count < 0)   return false;
        }
        
        
        return count == 0 ;
    }

}





/*


//TC : O(N^N) -- For n letters --> n-1 -> n-2 -> n-3 like this for worst case
//SC : O(N) -- For queue and set
//BFS Solution
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        
        if(s == null || s.length() == 0)    return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(s); set.add(s);
        
        boolean flag = false;
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i = 0; i< n; i++){
                String curr = queue.poll();
                if(isValidString(curr)){
                    result.add(curr);
                
                    flag = true;
                }
                
                if(!flag){ // If cuurent string is not valid then we will remove 1 character and select all the possibilities
                    for(int c = 0; c < curr.length(); c++){
                        if( Character.isLetter(curr.charAt(c) ) )   continue; // If character is alphabet then skip the iteratio
                        String subStr = curr.substring(0,c) + curr.substring(c+1);
                        if(!set.contains(subStr)){
                            queue.add(subStr); set.add(subStr);
                        }
                        
                        
                    }
                    
                }
            
        }
        
    }
    return result;
}

public boolean isValidString(String s){
        int count = 0;
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch))  continue;
            if(ch == '(')   count++;
            else if(ch == ')') count--;
            
            
            if(count < 0)   return false;
        }
        
        
        return count == 0 ;
    }

}

*/