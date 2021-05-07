class RemoveInvalidParantheses {
    
    // Time Complexity: O(n * n!)
    // Space Complexity: O(n!)
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        // Edge Case Checking
        if(s == null || s.length() == 0)
            return result;
        
        int n = s.length();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        set.add(s);
        boolean found = false;
        
        while(!q.isEmpty()){
            String curr = q.poll();
            // If the current string is valid  --> then only we add it to out final result explore it ahead
            if(isValid(curr)){
                found = true;
                result.add(curr);
            }

            // If we didnt find a valid string --> then we generate children substrings (permuatations)
            if(!found){
                for(int j = 0; j < curr.length(); j++){
                    if(Character.isLetter(curr.charAt(j)))
                        continue;

                    String sub = curr.substring(0,j) + curr.substring(j+1, curr.length());
                    if(!set.contains(sub)){
                        set.add(sub);
                        q.offer(sub);
                    }
                }
            }
        }
    
        return result;
    }
    
    // Check if a string has valid parantheses or not
    private boolean isValid(String s){
        int n = s.length();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '(')
                count++;
            else if(c == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        
        return count == 0;
    }
}