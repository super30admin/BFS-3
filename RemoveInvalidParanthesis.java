//TC : O(n*2^n) , At each stage two decisions are made
//SC : O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
         Queue<String> q = new LinkedList<>();
        q.add(s);
        
        if(s == null)
            return null;
    
        boolean flag = false;
       
        
        while(!q.isEmpty()){
            String curr = q.poll();
            
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            
            if(!flag){
                for(int i=0;i<curr.length();i++){
                    if(!Character.isLetter(curr.charAt(i))){
                        String temp = curr.substring(0,i)+ curr.substring(i+1);
                        if(!set.contains(temp)){
                            set.add(temp);
                            q.add(temp);
                        }
                    }
                }
            }
            
        }
      
        return result;
            
    }
    
    private boolean isValid(String s){
        if(s.length() == 0 || s == null)
            return true;
        
        int count =0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
           
            if(c == '(')
                count++;
            else if(c==')'){
                count--;
                if(count< 0)
                    return false;
                
            }
        }
        
        return count == 0;
    }
}

