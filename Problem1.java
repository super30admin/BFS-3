//301 Remove Invalid Parenthesis
// time - exponential
// spance - o(n!)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        HashSet<String> set = new HashSet<>();
        
        ArrayList<String> result = new ArrayList();
        
        Queue<String> q = new LinkedList();
        q.add(s);
        
        boolean validFound = false;
        while(!q.isEmpty() && !validFound){
            
            int level = q.size();
            
            for(int i = 0; i < level; i++){
                
                String currString = q.poll();
                
                if(isValid(currString)){
                    
                    result.add(currString);
                    validFound = true;
                }
                
                
                for(int j = 0; j < currString.length(); j++){
                    
                    if(currString.charAt(j) == '(' || currString.charAt(j) == ')'){
                    
                        String tempString = currString.substring(0, j) + currString.substring(j+1);
                    
                        if(!set.contains(tempString))
                        {
                            set.add(tempString);
                            q.add(tempString);
                         }
                    }

                    
                }
            }
        }
        
        return result;
    }
    
    public boolean isValid(String temp){
        
        int length = 0;
        
        for(int i = 0; i < temp.length(); i++){
            
            if(temp.charAt(i) == '('){
                length++;
            }else if(temp.charAt(i) == ')')
            {   
                if(length == 0){
                    return false;
                }
                length--;
            }
        }
        
        return length == 0;
    }
}