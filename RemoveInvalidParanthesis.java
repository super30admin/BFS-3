class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        // sanity check
        if(s == null || s.length() == 0){
            return result;
        }
        // hashset is used to keep track of already visited nodes
        // queue conatians all possible strings generated
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        visited.add(s);
        q.add(s);
        
        // if the found is turned true, we doesnot need to genetate next level strings anymore
        boolean found = false;
        
        while(!q.isEmpty()){
            String str = q.poll();
            
            // if the string is valid, make fount to true and add it to result
            if(isValid(str)){
                found = true;
                result.add(str);
                continue;
            }
            
            if(!found){
                for(int i = 0; i < str.length(); i++){
                    // skip if character is a letter
                    if(Character.isLetter(str.charAt(i))){
                        continue;
                    }
                    
                    // generate next possible substring
                    String sub = str.substring(0,i) + str.substring(i+1, str.length());
                    
                    // if not in visited then add to visited and to queue
                    if(!visited.contains(sub)){
                        visited.add(sub);
                        q.add(sub);
                    }
                }
            }
        }
        
        //return result
        return result;
    }
    
    private boolean isValid(String s){
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) =='('){
                count += 1;
            }else if(s.charAt(i) == ')'){
                if(count == 0){
                    return false;
                }
                count -= 1;
            }
        }
        
        return count == 0;
    }
}