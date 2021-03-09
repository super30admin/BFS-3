class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        if(s == null) return result;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.add(s);
        visited.add(s);
        boolean found = false;
        
        while(!q.isEmpty()){
            
            s = q.poll();
            
            if(isValid(s)){
                result.add(s);
                found = true;
            }
            
            if(found) continue;
            
            for(int i = 0; i < s.length(); i++){
                char currChar = s.charAt(i);
                if(currChar != '(' && currChar != ')') continue;
                String temp = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(temp)){
                    q.add(temp);
                    visited.add(temp);
                }
            }
            
            
        }
        
        return result;
        
    }
    
    private boolean isValid(String s){
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '(') counter++;
            if(currChar == ')') counter--;
            if(counter < 0) return false;
        }
        
        return counter == 0;
    }
}