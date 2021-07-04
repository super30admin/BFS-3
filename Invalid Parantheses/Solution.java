class Solution {
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') {
                if(count == 0) return false;
                count--;
            }
        }
        
        return count == 0;
    }
    public List<String> removeInvalidParentheses(String s) {
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        boolean found = false;
        
        
        queue.add(s);
        set.add(s);
        
        while(!queue.isEmpty()) {
            
            s = queue.poll();

            // check if valid string
            if(isValid(s)) {
                result.add(s);
                found = true;
            }
            
            // if even a single valid string is not found - proceed to insert possible subsets into queue
            if(!found) {
                for(int i=0;i<s.length();i++) {
                    if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                        String t = s.substring(0,i) + s.substring(i+1);
                        if(!set.contains(t)) {
                            queue.add(t);
                            set.add(t);
                        }                        
                    }
                }
            }
        }
        
        return result;
    }
}