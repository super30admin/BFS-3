class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }
                if(!flag){
                    for(int j=0; j<curr.length(); j++){
                        char c = curr.charAt(j);
                        if(Character.isLetter(c)) continue;
                        String child = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(child)){
                            q.add(child);
                            set.add(child);
                        }
                        
                    }
                }
            }
        }
         return result;   
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            
            if(c == '(') count++;
            else if(c == ')') count--;
            if(count < 0) return false;
        }
        
        return (count == 0);
    }
    
}



    
