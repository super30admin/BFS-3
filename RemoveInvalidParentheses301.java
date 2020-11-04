class Solution {

    // TC:  O(2^n) - at every step, we are checking valid - not valid (Choose, don't choose) --> 2 power n
    // SC:  O(n)

    public List<String> removeInvalidParentheses(String s) {
        if(s == null)
            return new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> output = new ArrayList<>();
        
        queue.add(s);
        set.add(s);
        
        String front = new String();
        String val = new String();
        boolean found = false;
        while(!queue.isEmpty()){
            front = queue.poll();
            
            if(isValid(front)){
                output.add(front);
                found = true;
            }
            
            if(!found){
                for(int x = 0; x < front.length(); x++){
                    // non braces
                    if(front.charAt(x) != ')' && front.charAt(x) != '('){
                        continue;
                    }

                    val = front.substring(0, x) + front.substring(x + 1, front.length());

                    if(!set.contains(val)){
                        set.add(val);
                        queue.add(val);
                    }
                
                }
            }
            
        }
        return output;
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ')' && str.charAt(i) != '('){
                continue;
            }
            
            if(str.charAt(i) == '(')
                count += 1;
            
            if(count == 0 && str.charAt(i) == ')')
                return false;

            if(str.charAt(i) == ')')
                count -= 1;
        }
        return count == 0;
    }
}