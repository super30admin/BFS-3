class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //Base:
        if(s==null || s.length()==0){
            return result;
        }
        
        
        //Logic:
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while(!q.isEmpty() && !found){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    found=true;
                    result.add(curr);
                }else if(!found){
                    for(int j=0; j<curr.length(); j++){
                        if(Character.isLetter(curr.charAt(j))) continue;
                        String baby = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(baby)){
                            q.add(baby);
                            set.add(baby);
                        }
                    }
                }
            }
            
        }
        return result;
    }
    
    private boolean isValid(String s){
        // if(s.length % 2 != 0) return false;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                //Negative indicates imbalance of braces
                if(count==0) return false;
                count--;
            }else if(c == '('){
                count++;
            }
        }
        return count == 0;
    }
}
