//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        if(s.length() == 0){
            
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<>();
        
        Queue<String> q1 = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q1.add(s);
        boolean flag = false;
        while(!q1.isEmpty() && flag == false){
            
            int size = q1.size();
                
        for(int k = 0; k < size; k ++){
            
              String curr = q1.poll();
            
             if(isValid(curr)){
                  //  System.out.println("itting");
                    flag = true;
                    set.add(curr);
                    result.add(curr);
                }
            if(!flag){
                
                for(int i = 0; i < curr.length(); i ++){
                
                String temp = curr.substring(0,i) + curr.substring(i+1);
                // System.out.println("temp"+ temp);
               
                if(!set.contains(temp)){
                    
                q1.add(temp);
                set.add(temp);
                }
                
            }
                
            }
           
            
        }
          
        }
        return result;
    }
    
    private boolean isValid(String s){
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i ++){
            
            if(s.charAt(i) == '('){
                
                count ++;
            }
            
            else if(s.charAt(i) == ')'){
                
                if(count == 0){
                    
                    return false;
                }
                count --;
            }
        }
        
        if(count == 0){
            
            return true;
        }
        
        return false;
    }
}