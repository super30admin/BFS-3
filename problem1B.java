class Solution {
    int m, n;
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList();
        
        List<String> result = new ArrayList();
        set = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(s);
        boolean found = false;
        
        while(!q.isEmpty() || !found){
            String curr = q.poll();
            if(isValid(curr)){
                result.add(curr);
                found = true;
            }
            else{
                if(found == false){
                    for(int i = 0; i < curr.length(); i++){
                        if(Character.isLetter(curr.charAt(i))) continue;
                        String sub = curr.substring(0, i) + curr.substring(i + 1);
                        if(!set.contains(sub)){
                            set.add(sub);
                            q.add(sub);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}

//time complexity O(2^n) 
//space complexity O(2^n)